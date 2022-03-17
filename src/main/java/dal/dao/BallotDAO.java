package dal.dao;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Forum;
import dal.InMemoryRepository;
import dal.dao.interfaces.IBallotDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class BallotDAO implements IBallotDAO {

    private InMemoryRepository repository = InMemoryRepository.initialize();
    private Ballot temporaryBallot;


    //TODO Changer le type de retour du stream pour un type correct (voir BallotBoxConsoleDriver)
    @Override
    public void create(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters) {
        Ballot ballot = new Ballot(title,start,end,isPublic,isAnonymous,runners,forum,owner,voters);
        temporaryBallot = ballot;
    }

    @Override
    public Ballot getBallotByTitle(String title) {
        Stream<Ballot> ballotByTitle = repository.getAllBallots().stream()
                .filter(ballot -> ballot.getTitle().equals(title));
        return (Ballot) ballotByTitle;
    }

    @Override
    public Ballot getBallotByBallot(Ballot ballot) {
        Stream<Ballot> ballotByBallot = repository.getAllBallots().stream()
                .filter(myBallot -> myBallot == ballot);
        return (Ballot) ballotByBallot;
    }

    @Override
    public Ballot getBallotById(int id) {
        Stream<Ballot> ballotById = repository.getAllBallots().stream()
                .filter(ballot -> ballot.getId() == id);
        return (Ballot) ballotById;
    }

    @Override
    public void update() {
        repository.getAllBallots().add(temporaryBallot);
    }

    @Override
    public void delete(Ballot ballot) {
        repository.getAllBallots().remove(ballot);
    }
}
