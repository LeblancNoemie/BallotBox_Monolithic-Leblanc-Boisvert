package dal;

import bll.model.*;
import net.andreinc.mockneat.MockNeat;


import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static net.andreinc.mockneat.unit.text.Words.words;
import static net.andreinc.mockneat.unit.types.Bools.bools;
import static net.andreinc.mockneat.unit.types.Ints.ints;

public class InMemoryRepository {

    private static InMemoryRepository dao = null;
    private MockNeat mock = MockNeat.old();

    private List<Ballot> ballotList;
    private List<Forum> forumList;
    private List<Post> postList;
    private List<Elector> electorList;
    private List<Candidate> candidateList;
    private List<Vote> voteList;

    //Singleton methods:
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
    populateBallotList(10);
    populateCandidateList();
    populateForumList();
    populateElectorList();
    populatePostList();
    populateVoteList();
    }

    //List getters methods:
    public List<Ballot> getAllBallotList() {
        return ballotList;
    }
    public List<Forum> getAllForumList() {
        return forumList;
    }
    public List<Post> getAllPostList() {
        return postList;
    }
    public List<Elector> getAllElectorList() {
        return electorList;
    }
    public List<Candidate> getAllCandidateList() {
        return candidateList;
    }
    public List<Vote> getAllVoteList() {
        return voteList;
    }

    //Populating methods:
    private void populateBallotList(int quantity){
        for(int i = 0; i<quantity; i++){
            String _title = words().nouns().get();
            LocalDate _start = generateRandomDate();
            LocalDate _end = generateRandomDate();
            boolean _isPublic = bools().probability(50.00).get();
            boolean _isAnonymous = bools().probability(50.00).get();
            List<Candidate> _candidateList = populateCandidateList(3,_title);
            Forum _forum = populateForumList(_title, _start);
            Elector _owner = populateElectorList(1);
            List<Elector> _voters = populateElectorList(10); //Mentionné la quantité de voters

            Ballot newBallot = new Ballot(_title, _start,_end, _isPublic, _isAnonymous, _candidateList, _forum, _owner, _voters);

            for(Candidate cd :_candidateList){
                cd.setPoll(newBallot);
            }
            ballotList.add(newBallot);
        }
    }

    private Forum populateForumList(String title, LocalDate creationDate){
        String _title = title + " forum";
        LocalDate _createdOn = creationDate;
        Forum forum = new Forum(_title,_createdOn);
        forumList.add(forum);
        return forum;
    }

    private void populatePostList(){

    }

    private void populateElectorList(int quantity){

    }

    private List<Candidate> populateCandidateList(int quantity, String ballotTitle){
        List<Candidate> ballotCandidateList = new ArrayList<>();
        for(int i = 0; i<quantity; i++){
            String _name = mock.names().get();
            String _description = "This is the description of the candidate " +_name + " .Candidate of the" + ballotTitle + " ballot";
            String _image = "Image"+_name+".png";
            Candidate candidate = new Candidate(_name,_description, _image);
            ballotCandidateList.add(candidate);
            candidateList.add(candidate);
        }
        return ballotCandidateList;

    }
    private void populateVoteList(){

    }

    private LocalDate generateRandomDate(){
        int _year = ints().range(Year.now().getValue(),2100).get();
        int _month = ints().range(1,12).get();
        int _day = ints().range(1,28).get();
        LocalDate newDate = LocalDate.of(_year,_month,_day);
        return newDate;

    }


}
