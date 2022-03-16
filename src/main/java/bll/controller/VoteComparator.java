package bll.controller;

import bll.model.Candidate;

import java.util.Comparator;
import java.util.Map;

public class VoteComparator implements Comparator {

    public VoteComparator() {}

    @Override
    public int compare(Object o1, Object o2) {
        Map.Entry<Candidate, Integer> e1 = (Map.Entry<Candidate, Integer>)o1;
        Map.Entry<Candidate, Integer> e2 = (Map.Entry<Candidate, Integer>)o2;

        return e1.getValue() - e2.getValue();
    }
}
