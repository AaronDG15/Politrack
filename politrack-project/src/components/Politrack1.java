package src.components;

import components.map.*;
import components.map.Map.Pair;
import components.map.Map1L;

public class Politrack1 extends PolitrackSecondary {

    //The map containing all of the participating candidates and their parties
    Map<String, String> candidate = new Map1L<String, String>();
    //The map containing each poll (polling average, winner)
    Map<Double, String> polls = new Map1L<>();
    //The type of the race (i.e. House, Senate, President, etc.)
    String raceType;

    //no args constructor, sets the race to Not Specified
    public Politrack1() {
        this.raceType = "Not Specified";
    }

    //constructor that includes the raceType
    public Politrack1(String race) {
        this.raceType = race;
    }


    public void addCandidates(String name, String party) {
        this.candidate.add(name, party);
    }


    public Pair<String, String> getCandidate(String affiliation) {
        assert this.candidate.hasValue(affiliation) != false: "Violation of: Candidate is in this.candidate";

        Map<String, String> temp = new Map1L<>();
        String title = null;
        String party = null;
        for(Pair<String, String> x: this.candidate) {
            if(x.value().equals(affiliation)) {
                title = x.key();
                party = x.value();
            }
        }
        temp.add(title, party);
        return temp.remove(title);
    }


    public Map<String, String> getAllCandidates() {
        return this.candidate;
    }


    public Map<Double, String> getAllPolls() {
        return this.polls;
    }


    public void addPoll(String winner, Double margin) {
        this.polls.add(margin, winner);
    }


    public Map<Double, String> getPolls(String winner) {
        assert this.polls.hasValue(winner) != false: "Violation of: Candidate is in this.polls";

        Map<Double, String> temp = this.polls.newInstance();
        Map<Double, String> sender = this.polls.newInstance();
        for(Pair<Double, String> x: this.polls) {
            if(x.value().equals(winner)) {
                sender.add(x.key(), x.value());
            }
            temp.add(x.key(), x.value());
        }
        this.polls.transferFrom(temp);
        return sender;
    }


    public void setRace(String raceType){
        this.raceType = raceType;
    }

    /**
     * @returns this.race
     */
    public String getRace() {
        return this.raceType;
    }


    @Override
    public final Politrack1 newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void clear() {
        Map<String, String> a = this.candidate.newInstance();
        Map<Double, String> b = this.polls.newInstance();
        this.candidate = a;
        this.polls = b;
        this.raceType = "Not Specified";

    }

    @Override
    public final void transferFrom(Politrack x) {
        assert x != null : "Violation of: source is not null";
        assert x != this : "Violation of: source is not this";
        assert x instanceof Politrack1 : "Violantion of: source is not Politrack1";

        Politrack temp = (Politrack1)x;
        this.candidate = temp.getAllCandidates();
        this.polls = temp.getAllPolls();
        this.raceType = temp.getRace();
        x.clear();
    }








}