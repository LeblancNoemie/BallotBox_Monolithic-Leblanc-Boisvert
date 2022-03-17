package bll.controller;

import bll.model.*;

import java.time.LocalDate;
import java.util.*;

public class BallotController {

    //TODO Doubler les méthodes avec les IDs comme inputs

    /* Ancien Vote Comparator au cas ou on en aurai besoin
        Comparator<Map.Entry<Candidate, Integer>> voteComparator = new Comparator<Map.Entry<Candidate, Integer>>() {
            @Override
            public int compare(Map.Entry<Candidate, Integer> o1, Map.Entry<Candidate, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
     */

    public Candidate findMONOSCANWinner(Ballot poll)
    {
        HashMap<Candidate, Integer> count = new HashMap<Candidate, Integer>();

        for(Vote v : poll.getVotes())
        {
            if(v.getRank() == 1)
            {
                int voteCount = count.containsKey(v.getSubject()) ? count.get(v.getSubject()) : 0;
                count.put(v.getSubject(), voteCount + 1);
            }
        }
        List<Map.Entry<Candidate, Integer>> listOfVoteCounts = new LinkedList<Map.Entry<Candidate, Integer>>(count.entrySet().stream().toList());
        System.out.println("ici");
        Collections.sort(listOfVoteCounts, new VoteComparator());
        System.out.println("la");
        return listOfVoteCounts.stream().findFirst().get().getKey();
    }

    //TODO Reparer.
    public Candidate findPOLYSCANWinner(Ballot poll)
    {
        HashMap<Candidate, Integer> count = new HashMap<Candidate, Integer>();
        List<Map.Entry<Candidate, Integer>> listOfVoteCounts = new ArrayList<>();

        List<Candidate> eliminatedCandidates = new ArrayList<>();
        do
        {
            eliminatedCandidates.add(listOfVoteCounts.stream().findFirst().get().getKey());
            count = new HashMap<>();

            for(Elector e : poll.getVoters())
            {
                List<Vote> voteList = e.getVotes();

                Collections.sort(voteList, new Comparator<Vote>() {
                    @Override
                    public int compare(Vote o1, Vote o2) {
                        return o1.getRank() - o2.getRank();
                    }
                });

                for(Vote v : voteList)
                {
                    if(v.getPoll().equals(poll))
                    {
                        if(eliminatedCandidates.contains(v.getSubject()))
                        {
                            continue;
                        }else
                        {
                            int voteCount = count.containsKey(v.getSubject()) ? count.get(v.getSubject()) : 0;
                            count.put(v.getSubject(), voteCount + 1);
                        }
                    }
                }
            }

            listOfVoteCounts = count.entrySet().stream().toList();
            Collections.sort(listOfVoteCounts, new VoteComparator());
        } while(listOfVoteCounts.stream().findFirst().get().getValue() < listOfVoteCounts.size()/2);


        return listOfVoteCounts.stream().findFirst().get().getKey();
    }

    public int findVoteCount(Ballot poll)
    {
        return poll.getVotes().size();
    }

    public Ballot createBallot(String Title, LocalDate end, Boolean isPublic, Boolean isAnonymous, List<Candidate> runners, Forum forum, Elector owner, List<Elector> voters) // le create vote des consignes, renommer pour être plus lisible
    {
        Ballot newBallot = new Ballot(Title, LocalDate.now(), end, isPublic, isAnonymous, runners, forum, owner, voters);

        for(Candidate c : runners)
        {
            c.setPoll(newBallot);
        }

        for(Elector e : voters)
        {
            e.addOpenPoll(newBallot);
        }

        owner.addOwnedPoll(newBallot);

        return newBallot;
    }
}
