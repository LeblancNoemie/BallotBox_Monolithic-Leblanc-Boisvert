package bll.model;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
    private static int AUTO_INCREMENT = 0;
    private int id;
    private String name;
    private String description;
    private String image;

    private Ballot poll;
    private List<Vote> votes = new ArrayList<>();

    public Candidate(String name, String description, String image, Ballot poll)
    {
        this.id = AUTO_INCREMENT++;
        this.name = name;
        this.description = description;
        this.image = image;

        this.poll = poll;
    }

    public Candidate(String name, String description, String image)
    {
        this.id = AUTO_INCREMENT++;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    // Getter Setter \/\/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Ballot getPoll() {
        return poll;
    }

    public void setPoll(Ballot poll) {
        this.poll = poll;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    // Methods

    public void addVote(Vote vote)
    {
        this.votes.add(vote);
    }

    public void removeVote(Vote vote)
    {
        this.votes.remove(vote);
    }

}
