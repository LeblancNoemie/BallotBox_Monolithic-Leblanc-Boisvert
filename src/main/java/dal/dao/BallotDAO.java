package dal.dao;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Forum;
import dal.InMemoryRepository;
import dal.dao.interfaces.IBallotDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BallotDAO implements IBallotDAO {

    private static InMemoryRepository repository = InMemoryRepository.initialize();
    private Ballot temporaryBallot;

    public static Optional<Ballot> getBallotByTitle(String title) {
         return repository.getAllBallots().stream()
                .filter(ballot -> ballot.getTitle().equals(title)).findFirst();
    }
    public static Optional<Ballot> getBallotByBallot(Ballot ballot) {
        return repository.getAllBallots().stream()
                .filter(myBallot -> myBallot == ballot).findFirst();
    }
    public static Optional<Ballot> getBallotById(int id) {
        return repository.getAllBallots().stream()
                .filter(ballot -> ballot.getId() == id).findFirst();
    }

    public void create(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters) {
        temporaryBallot = new Ballot(title,start,end,isPublic,isAnonymous,runners,forum,owner,voters);
    }
    public void update() {
        repository.getAllBallots().add(temporaryBallot);
    }
    public void delete(Ballot ballot) {
        repository.getAllBallots().remove(ballot);
    }
}
