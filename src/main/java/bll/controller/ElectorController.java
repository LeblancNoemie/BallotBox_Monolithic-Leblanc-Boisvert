package bll.controller;

import bll.model.Ballot;
import bll.model.Candidate;
import bll.model.Elector;

public class ElectorController {
    //TODO Doubler les méthodes avec les IDs comme inputs


    public void addVoter(Ballot poll, Elector newVoter)
    {
        poll.addVoter(newVoter);
    }

    public void addRunner(Ballot poll, Candidate newRunner)
    {
        poll.addCandidate(newRunner);
    }
}
