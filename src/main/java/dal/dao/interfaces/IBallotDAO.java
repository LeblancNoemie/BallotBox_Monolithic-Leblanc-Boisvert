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

    void create(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters);
    public Ballot getBallotByTitle(String title);
    public Ballot getBallotByBallot(Ballot ballot);

    //TODO cahnger toute les dao et idao en Optional

    public static Optional<Ballot> getBallotById(int id) { return null;}
    public void update();
    public void delete(Ballot ballot);
}
