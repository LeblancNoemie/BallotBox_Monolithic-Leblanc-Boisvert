package dal;

import bll.model.*;
import net.andreinc.mockneat.MockNeat;


import java.time.LocalDate;
import java.time.Year;
import java.util.*;

import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.text.Words.words;
import static net.andreinc.mockneat.unit.types.Bools.bools;
import static net.andreinc.mockneat.unit.types.Ints.ints;

public class InMemoryRepository {

    private static InMemoryRepository dao = null;
    private MockNeat mock = MockNeat.old();

    private List<Ballot> ballotList = new ArrayList<>();
    private List<Forum> forumList  = new ArrayList<>();
    private List<Post> postList = new ArrayList<>();
    private List<Elector> electorList = new ArrayList<>();
    private List<Candidate> candidateList = new ArrayList<>();
    private List<Vote> voteList = new ArrayList<>();

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
    }

    //List getters methods:
    public List<Ballot> getAllBallots() {
        return ballotList;
    }
    public List<Forum> getAllForums() {
        return forumList;
    }
    public List<Post> getAllPosts() {
        return postList;
    }
    public List<Elector> getAllElectors() {
        return electorList;
    }
    public List<Candidate> getAllCandidates() {
        return candidateList;
    }
    public List<Vote> getAllVotes() {
        return voteList;
    }

    //Populating methods:
    private void populateBallotList(int quantity){
        for(int i = 0; i<quantity; i++){

            //Tous les attributs nécéssaires à la création d'un ballot
            String title = words().nouns().get();
            LocalDate start = generateRandomDate();
            LocalDate end = generateRandomDate();
            boolean isPublic = bools().probability(50.00).get();
            boolean isAnonymous = bools().probability(50.00).get();
            List<Candidate> ballotCandidates = populateCandidateList(3,title);
            Forum forum = populateForumList(title, start);
            List<Elector> voters = populateElectorList(10); //Mentionné la quantité de voters
            Elector owner = voters.get(new Random().nextInt(voters.size()));

            Ballot newBallot = new Ballot(title, start,end, isPublic, isAnonymous, ballotCandidates, forum, owner, voters);

            //Ajout des ballots aux candidats/electeurs
            for(Candidate candidate :ballotCandidates){
                candidate.setPoll(newBallot);
            }

            //Ajout de ballots et de votes aux électeurs
            for(Elector elector : voters){
                elector.addOpenPoll(newBallot);
                Candidate winner = ballotCandidates.get(new Random().nextInt(ballotCandidates.size()));
                populateVoteList(start,winner,elector,newBallot);
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
    private List<Elector> populateElectorList(int quantity){
        List<Elector> ballotElectors = new ArrayList<>();
        for(int i = 0;i<quantity;i++){
            String _login = mock.names().get();
            String _password = strings().size(ints().range(6,15)).get();
            int _weight = ints().range(90,500).get();
            String _email = mock.emails().get();
            Elector elector = new Elector(_login, _password, _weight, _email);

            //Ajout à la liste de retour et à la liste globale:
            ballotElectors.add(elector);
            electorList.add(elector);
        }
        return ballotElectors;
    }
    private List<Candidate> populateCandidateList(int quantity, String ballotTitle){
        List<Candidate> ballotCandidate = new ArrayList<>();
        for(int i = 0; i<quantity; i++){
            String _name = mock.names().get();
            String _description = "This is the description of the candidate " +_name + " .Candidate of the" + ballotTitle + " ballot";
            String _image = "Image"+_name+".png";
            Candidate candidate = new Candidate(_name,_description, _image);

            //Ajout à la liste de retour et à la liste globale:
            ballotCandidate.add(candidate);
            candidateList.add(candidate);
        }
        return ballotCandidate;

    }
    private void populateVoteList(LocalDate when, Candidate subject, Elector voter, Ballot ballot){
        List<Integer> ranks = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Collections.shuffle(ranks);

        for(int i = 0; i < ballot.getRunners().size(); i++)
        {
            Vote _vote = new Vote(when, ranks.get(i),ballot.getRunners().get(i), voter,ballot);

            ballot.addVote(_vote);
            voteList.add(_vote);
        }
        /*
        //Seulement le rank est généré:
        int rank = ints().range(1,10).get();
        Vote vote = new Vote(when,rank,subject,voter,ballot);
        */

    }
    private void populatePostList(){
    }

    private LocalDate generateRandomDate(){
        int _year = ints().range(Year.now().getValue(),2050).get();
        int _month = ints().range(1,12).get();
        int _day = ints().range(1,28).get();
        LocalDate newDate = LocalDate.of(_year,_month,_day);
        return newDate;
    }


}
