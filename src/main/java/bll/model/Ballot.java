package bll.model;

import java.time.LocalDate;
import java.util.List;

public class Ballot {
    private int id;
    private String title;
    private LocalDate start;
    private LocalDate end;
    private boolean isPublic;
    private boolean isAnonymous;

    private List<Candidate> runners;
    private Forum forum;
    private Elector owner;
    private Elector voters;

    //TODO CONSTRUCTEUR

    //TODO GETTER SETTER

}
