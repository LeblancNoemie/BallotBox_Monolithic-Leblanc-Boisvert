package fel;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Vote;
import dal.InMemoryRepository;
import fel.view.BallotBoxConsoleDriver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        BallotBoxConsoleDriver driver = new BallotBoxConsoleDriver();

        InMemoryRepository dao = InMemoryRepository.initialize();

        for(Ballot ballot:dao.getAllBallots()){
            Candidate candidate = driver.run_usingInMemoryRepository(ballot);
            System.out.println(candidate.getName() + " " + candidate.getVotes().size());

        }

    }
}
