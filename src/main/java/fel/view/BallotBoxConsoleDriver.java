package fel.view;

import bll.controller.BallotController;
import bll.model.Ballot;
import bll.model.Candidate;
import dal.InMemoryRepository;
import dal.dao.BallotDAO;

public class BallotBoxConsoleDriver {
    private BallotController ballotController = new BallotController();
    private BallotDAO dao = new BallotDAO();

    //TODO Controller pas correct (voir BallotDAO)
    public Candidate run_usingInMemoryRepository(Ballot ballot){
        return ballotController.findMONOSCANWinner(dao.getBallotById(ballot.getId()));
    }
}
