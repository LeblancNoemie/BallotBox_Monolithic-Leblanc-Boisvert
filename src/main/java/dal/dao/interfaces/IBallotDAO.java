package dal.dao.interfaces;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Forum;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IBallotDAO {

    //TODO Changer les autres dao et idao des autres class comme celle-ci

    void create(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters);
    public void update();
    public void delete(Ballot ballot);
    public static Optional<Ballot> getBallotByTitle(String title) {return null;}
    public static Optional<Ballot> getBallotByBallot(Ballot ballot) {return null;}
    public static Optional<Ballot> getBallotById(int id) { return null;}
}
