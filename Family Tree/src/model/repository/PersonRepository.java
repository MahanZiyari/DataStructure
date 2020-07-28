package model.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.Node;

import java.sql.*;

public class PersonRepository implements AutoCloseable {
    Connection connection;
    PreparedStatement preparedStatement;

    public PersonRepository() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe", "mahan","admin");
        connection.setAutoCommit(false);
    }

    public void create(String familyName) throws Exception{
        Statement creatationStatment = connection.createStatement();
        String statement = "create table " + familyName + "(id varchar2(20) primary key, name varchar2(20), lastName varchar2(20), "
                + "birth varchar2(20), death varchar2(20), gender varchar2(20), partner varchar2(20), father varchar2(20))";
        creatationStatment.executeUpdate(statement);
    }

    public void insert(Node node, String family) throws Exception{
        String statment = "insert into " + family + "(id, name, lastName, birth, death, gender, partner, father) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(statment);
        preparedStatement.setString(1, node.getId());
        preparedStatement.setString(2, node.getName());
        preparedStatement.setString(3, node.getLastName());
        preparedStatement.setString(4, node.getDateOfBirth());
        preparedStatement.setString(5, node.getDateOfDeath());
        preparedStatement.setString(6, node.getGender());
        preparedStatement.setString(7, node.partners.get(0).getId());
        preparedStatement.setString(8, node.getFather());
        preparedStatement.executeUpdate();
    }

    public void update(Node node, String family) throws Exception{
        String statement = "update " + family + "set name = ?, lastName = ?, birth = ?, death = ?, gender = ?, partner = ?, " +
                "father = ? where id = ?";
        preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setString(1, node.getName());
        preparedStatement.setString(2, node.getLastName());
        preparedStatement.setString(3, node.getDateOfBirth());
        preparedStatement.setString(4, node.getDateOfDeath());
        preparedStatement.setString(5, node.getGender());
        preparedStatement.setString(6, node.partners.get(0).getId());
        preparedStatement.setString(7, node.getFather());
        preparedStatement.setString(8, node.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Node node, String family) throws Exception{
        String statement = "delete from " + family + "where id = ?";
        preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setString(1, node.getId());
        preparedStatement.executeUpdate();
    }

    public ObservableList<Node> select(String family) throws Exception{
        String statement = "select * from" + family;
        preparedStatement = connection.prepareStatement(statement);
        ResultSet resultSet = preparedStatement.executeQuery();
        ObservableList<Node> familyMembers = FXCollections.observableArrayList();
        while (resultSet.next()){
            Node node = new Node()
                    .setId(resultSet.getString("id"))
                    .setName(resultSet.getString("name"))
                    .setLastName(resultSet.getString("lastName"))
                    .setGender(resultSet.getString("gender"))
                    .setDateOfBirth(resultSet.getString("birth"))
                    .setDateOfDeath(resultSet.getString("death"))
                    .setFather(resultSet.getString("father"))
                    .partners.get(0).setId(resultSet.getString("partner"));
            familyMembers.add(node);
        }
        return familyMembers;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollBack() throws Exception{
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
