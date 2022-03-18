package dal.dao;

import bll.model.Elector;
import dal.InMemoryRepository;
import dal.dao.interfaces.IElectorDAO;

import java.util.Optional;

public class ElectorDAO implements IElectorDAO {
    private static InMemoryRepository repository = InMemoryRepository.initialize();
    private Elector temporary;
    //Git test

    public void create(String login, String password, int weight, String email) {
        temporary = new Elector(login, password,weight,email);
    }
    public void update() {
        repository.getAllElectors().add(temporary);
    }
    public void delete(Elector elector) {
        repository.getAllElectors().remove(elector);
    }

    public static Optional<Elector> getElectorByEmail(String email) {
        return repository.getAllElectors().stream()
                .filter(elector -> elector.getEmail().equals(email)).findFirst();
    }

    public static Optional<Elector> getElectorByLogin(String login) {
        return repository.getAllElectors().stream()
                .filter(elector -> elector.getLogin().equals(login)).findFirst();
    }

    public static Optional<Elector> getElectorById(int id) {
        return repository.getAllElectors().stream()
                .filter(elector -> elector.getId() == id).findFirst();
    }


}
