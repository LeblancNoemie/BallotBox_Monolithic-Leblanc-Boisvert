package bll.model;

import java.time.LocalDate;

public class Vote {
    private static int AUTO_INCREMENT = 0;
    private int id;
    private LocalDate when;
    private int rank;

    private Candidate subject;
    private Elector voter;

    private Ballot poll;

    public Vote(LocalDate when, int rank, Candidate subject, Elector voter, Ballot poll) {
        this.when = when;
        this.rank = rank;
        this.subject = subject;
        this.voter = voter;
        this.id = AUTO_INCREMENT++;
        this.poll = poll;
    }

    //MÉTHODES UTILITAIRES ->
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getWhen() {
        return when;
    }

    public void setWhen(LocalDate when) {
        this.when = when;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Candidate getSubject() {
        return subject;
    }

    public void setSubject(Candidate subject) {
        this.subject = subject;
    }

    public Elector getVoter() {
        return voter;
    }

    public void setVoter(Elector voter) {
        this.voter = voter;
    }

    public Ballot getPoll() {
        return poll;
    }

    public void setPoll(Ballot poll) {
        this.poll = poll;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", when=" + when +
                ", rank=" + rank +
                ", subject=" + subject +
                ", voter=" + voter +
                '}';
    }
}
