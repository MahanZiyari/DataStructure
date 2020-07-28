package model.service;

import javafx.collections.ObservableList;
import model.entity.Node;
import model.repository.PersonRepository;

public class PersonService {
    private static PersonService ourInstance = new PersonService();

    public static PersonService getInstance() {
        return ourInstance;
    }

    private PersonService() {
    }

    public void create(String family) throws Exception{
        try (PersonRepository repository = new PersonRepository()){
            repository.create(family);
            repository.commit();
        }
    }

    public void save(Node node, String family) throws Exception{
        try (PersonRepository repository = new PersonRepository()){
            repository.insert(node, family);
            repository.commit();
        }
    }

    public void edit(Node node, String family) throws Exception{
        try (PersonRepository repository = new PersonRepository()){
            repository.update(node, family);
            repository.commit();
        }
    }

    public void remove(Node node, String family) throws Exception{
        try (PersonRepository repository = new PersonRepository()){
            repository.delete(node, family);
            repository.commit();
        }
    }

    public ObservableList<Node> report(String family) throws Exception{
        ObservableList<Node> familyMembers;
        try (PersonRepository repository = new PersonRepository()){
            familyMembers = repository.select(family);
        }
        return familyMembers;
    }
}
