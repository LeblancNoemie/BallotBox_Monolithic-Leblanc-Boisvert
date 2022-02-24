package bll.model;

import java.util.List;

public class Elector {
    private int id;
    private String login;
    private String password;
    private int weight;
    private String email;
    private int voterId;

    private List<Post> posts;
    private List<Ballot> ownedPolls;
    private List<Ballot> openPolls;
    private List<Vote> votes;

    public Elector(int id, String login, String password, int weight, String email, int voterId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.weight = weight;
        this.email = email;
        this.voterId = voterId;
    }

    //MÉTHODES DE LISTES ->
    public void addPosts(Post newPost){
        this.posts.add(newPost);
    }

    public List<Post> getPosts(){
        return this.posts;
    }

    public void addOwnedPolls(Ballot newBallot){
        this.ownedPolls.add(newBallot);
    }

    public List<Ballot> getOwnedPolls(){
        return this.ownedPolls;
    }

    public void addOpenPolls(Ballot newBallot){
        this.openPolls.add(newBallot);
    }

    public List<Ballot> getOpenPolls(){
        return this.openPolls;
    }

    public void addVotes(Vote newVote){
        this.votes.add(newVote);
    }

    public List<Vote> getVotes(){
        return this.votes;
    }

    //MÉTHODES UTILITAIRES ->
    @Override
    public String toString() {
        return "Elector{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", email='" + email + '\'' +
                ", voterId=" + voterId +
                ", posts=" + posts +
                ", ownedPolls=" + ownedPolls +
                ", openPolls=" + openPolls +
                ", votes=" + votes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }
}
