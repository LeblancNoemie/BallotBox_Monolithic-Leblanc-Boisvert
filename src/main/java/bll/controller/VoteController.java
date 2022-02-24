package bll.controller;

import bll.model.Candidate;
import bll.model.Elector;
import bll.model.Vote;

import java.time.LocalDate;

public class VoteController {
    //TODO Doubler les méthodes avec les IDs comme inputs

    //findNumberOfInFavorByCandidate, Trouver le nombre de polls gagné? TODO

    public Vote createVote(Candidate subject, Elector voter, int rank)
    {
        Vote newVote = new Vote(LocalDate.now(), rank, subject, voter, subject.getPoll());

        subject.addVote(newVote);
        voter.addVote(newVote);

        subject.getPoll().addVote(newVote);

        return newVote;
    }
}
