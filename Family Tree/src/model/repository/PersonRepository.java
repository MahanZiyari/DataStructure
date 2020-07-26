package model.repository;

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










    @Override
    public void close() throws Exception {

    }
}
