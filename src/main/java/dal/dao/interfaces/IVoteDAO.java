package dal.dao.interfaces;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Vote;

import java.time.LocalDate;
import java.util.Optional;

public interface IVoteDAO {
    public void create(LocalDate when, int rank, Candidate subject, Elector voter, Ballot poll);
    public void update();
    public void delete(Vote vote);
    public static Optional<Vote> getVoteById(int id) {return null;}
}
