package dal.dao.interfaces;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Forum;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICandidatDAO {
    void create(String name, String description, String image, Ballot poll);
    public void update();
    public void delete(Candidate candidate);
    public static Optional<Candidate> getCandidateByName(String name) {return null;}
    public static Optional<Ballot> getBallotById(int id) {return null;}
}
