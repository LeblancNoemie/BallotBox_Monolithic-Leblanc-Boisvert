package bll.controller;

import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Vote;

import java.time.LocalDate;

public class VoteController {

    //TODO findNumberOfInFavorByCandidate, Trouver le nombre de polls gagné?
    //Utiliser comparator dans Votecomparator

    public Vote createVote(Candidate subject, Elector voter, int rank)
    {
        Vote newVote = new Vote(LocalDate.now(), rank, subject, voter, subject.getPoll());

        subject.addVote(newVote);
        voter.addVote(newVote);

        subject.getPoll().addVote(newVote);

        return newVote;
    }
}
