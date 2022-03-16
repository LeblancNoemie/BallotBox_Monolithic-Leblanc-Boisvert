package dal;

import bll.model.*;

import java.util.List;

public class InMemoryRepository {

    private static InMemoryRepository dao = null;

    private List<Ballot> ballotList;
    private List<Forum> forumList;
    private List<Post> postList;
    private List<Elector> electorList;
    private List<Candidate> candidateList;
    private List<Vote> voteList;

    public static InMemoryRepository initialize(){
        if(dao == null){
            return dao = new InMemoryRepository();
        }else {
            return dao;
        }
    }

    private InMemoryRepository(){
        populate();
    }

    private void populate(){

    }
}
