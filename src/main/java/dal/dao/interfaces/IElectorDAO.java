package dal.dao.interfaces;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;

import java.util.Optional;

public interface IElectorDAO {
    void create(String login, String password, int weight, String email);
    public void update();
    public void delete(Elector elector);
    public static Optional<Elector> getElectorByEmail(String email) {return null;}
    public static Optional<Elector> getElectorByLogin(String login) {return null;}
    public static Optional<Elector> getBallotById(int id) {return null;}
}
