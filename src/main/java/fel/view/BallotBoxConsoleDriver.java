package fel.view;

import bll.controller.BallotController;
import bll.model.Ballot;
import bll.model.Candidate;
import dal.dao.BallotDAO;

import java.util.Optional;

public class BallotBoxConsoleDriver {
    private BallotController ballotController = new BallotController();
    private BallotDAO dao = new BallotDAO();

    public Candidate runMONOSCAN_usingInMemoryRepository(String id){
        Optional<Ballot> _ballot = dao.getBallotById(Integer.valueOf(id));
        return _ballot.isPresent() ? ballotController.findMONOSCANWinner(_ballot.get()) : null;
    }

    public Candidate runPOLYSCAN_usingInMemoryRepository(String id)
    {
        Optional<Ballot> _ballot = dao.getBallotById(Integer.valueOf(id));
        return _ballot.isPresent() ? ballotController.findPOLYSCANWinner(_ballot.get()) : null;
    }
}
