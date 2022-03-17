package bll.model;

import java.time.LocalDate;
import java.util.List;

public class Ballot {
    private static int AUTO_INCREMENT = 0;
    private int id;
    private String title;
    private LocalDate start;
    private LocalDate end;
    private boolean isPublic;
    private boolean isAnonymous;

    private List<Candidate> runners;
    private Forum forum;
    private Elector owner;
    private List<Elector> voters;

    private List<Vote> votes;

    public Ballot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters) {
        this.id = AUTO_INCREMENT++;
        this.title = title;
        this.start = start;
        this.end = end;
        this.isPublic = isPublic;
        this.isAnonymous = isAnonymous;
        this.runners = runners;
        this.forum = forum;
        this.owner = owner;
        this.voters = voters;
    }

    // Getter Setter \/\/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public List<Candidate> getRunners() {
        return runners;
    }

    public void setRunners(List<Candidate> runners) {
        this.runners = runners;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Elector getOwner() {
        return (Elector) owner;
    }

    public void setOwner(Elector owner) {
        this.owner = owner;
    }

    public List<Elector> getVoters() {
        return voters;
    }

    public void setVoters(List<Elector> voters) {
        this.voters = voters;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    //Methods \/\/

    public void addVoter(Elector newVoter)
    {
        this.voters.add(newVoter);
    }

    public void removeVoter(Elector toRemove)
    {
        this.voters.remove(toRemove);
    }

    public void addCandidate(Candidate newCandidate)
    {
        this.runners.add(newCandidate);
    }

    public void removeCandidate(Candidate toRemove)
    {
        this.runners.remove(toRemove);
    }

    public void addVote(Vote newVote)
    {
        this.votes.add(newVote);
    }

    public void removeVote(Vote toRemove)
    {
        this.votes.remove(toRemove);
    }

}
