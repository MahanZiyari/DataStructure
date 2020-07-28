package model.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

public class Node {
    private StringProperty id, name, lastName, dateOfBirth, dateOfDeath, gender, father;
    public LinkedList<Node> partners = new LinkedList<>();

    public Node(String id, String name, String lastName, String dateOfBirth, String dateOfDeath, String gender, String partner, String father) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
        this.dateOfDeath = new SimpleStringProperty(dateOfDeath);
        this.gender = new SimpleStringProperty(gender);
        this.father = new SimpleStringProperty(father);
    }

    public Node() {
    }

    public String getFather() {
        return father.get();
    }

    public StringProperty fatherProperty() {
        return father;
    }

    public Node setFather(String father) {
        this.father.set(father);
        return this;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public Node setId(String id) {
        this.id.set(id);
        return this;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Node setName(String name) {
        this.name.set(name);
        return this;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public Node setLastName(String lastName) {
        this.lastName.set(lastName);
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth.get();
    }

    public StringProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public Node setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
        return this;
    }

    public String getDateOfDeath() {
        return dateOfDeath.get();
    }

    public StringProperty dateOfDeathProperty() {
        return dateOfDeath;
    }

    public Node setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath.set(dateOfDeath);
        return this;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public Node setGender(String gender) {
        this.gender.set(gender);
        return this;
    }

    public String caculateAge(){
        return null;
    }
}
