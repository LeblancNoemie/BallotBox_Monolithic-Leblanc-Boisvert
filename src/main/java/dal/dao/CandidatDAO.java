package dal.dao;

import bll.model.Ballot;
import bll.model.Candidate;
import dal.InMemoryRepository;
import dal.dao.interfaces.ICandidatDAO;

import java.util.Optional;

public class CandidatDAO implements ICandidatDAO {
    private Candidate temporary;
    private static InMemoryRepository repository = InMemoryRepository.initialize();

    public void create(String name, String description, String image, Ballot poll) {
        temporary = new Candidate(name, description,image,poll);
    }
    public void update() {
        repository.getAllCandidates().add(temporary);
    }
    public void delete(Candidate candidate) {
        repository.getAllCandidates().remove(candidate);
    }

    public static Optional<Candidate> getCandidateByName(String name) {
        return repository.getAllCandidates().stream()
                .filter(candidate -> candidate.getName().equals(name)).findFirst();
    }
    //Git test

    public static Optional<Candidate> getCandidateById(int id) {
        return repository.getAllCandidates().stream()
                .filter(candidate -> candidate.getId() == id).findFirst();
    }
}
