package src;
import components.simplereader.*;
import components.simplewriter.*;
import src.components.Politrack;
import src.components.Politrack1;
import components.map.*;
import components.map.Map.Pair;
import components.simplereader.SimpleReader1L;

public class SkewElectionSim {

    public static Pair<String, Double> genSkew(String party, Double margin) {
        Map<String, Double> temp = new Map1L<>();
        temp.add(party, margin);
        return temp.remove(party);
    }

    //All skews are based on 2020 election data
    public static Map<String, Pair<String, Double>> generateSkewList() {
        Map<String, Pair<String, Double>> skew = new Map1L<>();
        skew.add("AL", genSkew("Republican", 25.4));
        skew.add("AK", genSkew("Republican", 10.0));
        skew.add("AZ", genSkew("Democratic", 0.4));
        skew.add("AR", genSkew("Republican", 27.6));
        skew.add("CA", genSkew("Democratic", 29.2));
        skew.add("CO", genSkew("Democratic", 13.5));
        skew.add("CT", genSkew("Democratic", 19.9));
        skew.add("DC", genSkew("Democratic", 86.7));
        skew.add("DE", genSkew("Democratic", 18.9));
        skew.add("FL", genSkew("Republican", 3.3));
        skew.add("GA", genSkew("Democratic", 0.3));
        skew.add("HI", genSkew("Democratic", 29.4));
        skew.add("ID", genSkew("Republican", 30.7));
        skew.add("IL", genSkew("Democratic", 16.9));
        skew.add("IN", genSkew("Republican", 16.0));
        skew.add("IA", genSkew("Republican", 8.2));
        skew.add("KS", genSkew("Republican", 14.6));
        skew.add("KY", genSkew("Republican", 26.0));
        skew.add("LA", genSkew("Republican", 18.6));
        skew.add("ME", genSkew("Democratic", 9.1));
        skew.add("MD", genSkew("Democratic", 33.3));
        skew.add("MA", genSkew("Democratic", 33.5));
        skew.add("MI", genSkew("Democratic", 2.8));
        skew.add("MN", genSkew("Democratic", 7.1));
        skew.add("MS", genSkew("Republican", 16.5));
        skew.add("MO", genSkew("Republican", 15.4));
        skew.add("MT", genSkew("Republican", 16.4));
        skew.add("NE", genSkew("Republican", 19.0));
        skew.add("NV", genSkew("Democratic", 2.4));
        skew.add("NH", genSkew("Democratic", 7.3));
        skew.add("NJ", genSkew("Democratic", 15.8));
        skew.add("NM", genSkew("Democratic", 10.8));
        skew.add("NY", genSkew("Democratic", 23.2));
        skew.add("NC", genSkew("Republican", 1.3));
        skew.add("ND", genSkew("Republican", 33.3));
        skew.add("OH", genSkew("Republican", 8.1));
        skew.add("OK", genSkew("Republican", 33.1));
        skew.add("OR", genSkew("Democratic", 16.1));
        skew.add("PA", genSkew("Democratic", 1.2));
        skew.add("RI", genSkew("Democratic", 10.8));
        skew.add("SD", genSkew("Republican", 23.3));
        skew.add("TN", genSkew("Republican", 26.2));
        skew.add("SC", genSkew("Republican", 11.7));
        skew.add("TX", genSkew("Republican", 5.6));
        skew.add("UT", genSkew("Republican", 20.5));
        skew.add("VT", genSkew("Democratic", 35.4));
        skew.add("VA", genSkew("Democratic", 10.1));
        skew.add("WA", genSkew("Democratic", 19.2));
        skew.add("WV", genSkew("Republican", 58.9));
        skew.add("WI", genSkew("Democratic", 0.6));
        skew.add("WY", genSkew("Republican", 43.3));
        return skew;
    }
    public static void main(String[] args) {
        Map<String, Pair<String, Double>> skewList = generateSkewList();
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("What state is your race taking place in (Enter the postal abreviation i.e. 'OH'): ");
        String state = in.nextLine();
        try {
            assert true == skewList.hasKey(state);
        } catch (AssertionError e) {
            out.println("Entered invalid state abreviation");
            in.close();
            out.close();
            return;
        }
        out.print("Enter the type of race that is being run: ");
        String race = in.nextLine();
        Politrack comp = new Politrack1(race);
        out.print("How many people are running in this race: ");
        int numCand = in.nextInteger();
        for(int i = 1; i <= numCand; i++) {
            out.print("Enter the name for candidate " + i +": ");
            String name = in.nextLine();
            out.print("Enter the party of candidate " + i + ": ");
            String party = in.nextLine();
            comp.addCandidates(name, party);
        }
        out.print("How many polls would you like to add: ");
        int numPoll = in.nextInteger();
        for(int i = 1; i <= numPoll; i++) {
            out.print("Who won in poll " + i +": ");
            String winner = in.nextLine();
            out.print("What was the win margin: ");
            Double margin = in.nextDouble();
            comp.addPoll(winner, margin);
        }
        if(comp.getAllPolls().size() == 0) {
            String winParty = skewList.remove(state).value().key();
            out.println("The projected winner is " + comp.getCandidate(winParty));
        }
        in.close();
        out.close();
    }
}