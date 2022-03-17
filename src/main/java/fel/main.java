package fel;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Vote;
import dal.InMemoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        InMemoryRepository dao = InMemoryRepository.initialize();

        List<Ballot> ballots = dao.getAllBallot();

        for(Ballot ballot : ballots){
            System.out.println("-------------------");
            System.out.println(ballot.getTitle());
            System.out.println(ballot.getStart());
            System.out.println(ballot.getVoters().size());

        }

    }
}
