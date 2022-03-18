package dal.dao;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Vote;
import dal.InMemoryRepository;
import dal.dao.interfaces.IVoteDAO;

import java.time.LocalDate;
import java.util.Optional;

public class VoteDAO implements IVoteDAO {
    private Vote temporary;
    private static InMemoryRepository repository = InMemoryRepository.initialize();

    public void create(LocalDate when, int rank, Candidate subject, Elector voter, Ballot poll) {
        temporary = new Vote(when, rank, subject,voter,poll);
    }
    public void update() {
        repository.getAllVotes().add(temporary);
    }
    public void delete(Vote vote) {
        repository.getAllVotes().remove(vote);

    }

    public static Optional<Vote> getVoteById(int id) {
        return repository.getAllVotes().stream()
                .filter(vote -> vote.getId() == id).findFirst();
    }



}
