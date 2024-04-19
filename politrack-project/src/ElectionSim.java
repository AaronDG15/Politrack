package src;
import src.components.*;
import components.simplereader.*;
import components.simplewriter.*;

//This is simply an example of how the component could be used
public class ElectionSim {


    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("Enter the type of race you want to simulate: ");
        String raceName = in.nextLine();
        Politrack competition = new Politrack1(raceName);
        boolean quit = false;
        while(!quit) {
            out.print("Enter the name of a candidate (type q when finished): ");
            String cand = in.nextLine();
            if(cand.equals("q")) {
                quit = true;
            }
            else {
                out.print("What's their political party (enter independant if none): ");
                String party = in.nextLine();
                competition.addCandidates(cand, party);
            }
        }
        quit = false;
        while(!quit) {
            out.print("Would you like to enter a poll? (y or n): ");
            String answer = in.nextLine();
            if(answer.equals("y")){
                out.print("Who wins in the poll (enter a candidates name): ");
                String winner = in.nextLine();
                out.print("How many points did they win by (enter a double): ");
                Double margin = in.nextDouble();
                competition.addPoll(winner, margin);
            }
            else {
                quit = true;
            }

        }
        String winner = competition.getProjectedWinner();
        Double winMarg = competition.getPollAverage();
        String rating = competition.giveRating();
        out.println("The winner of the race is " + winner + ", with a margin of " + winMarg + " points, the race is rated as " + rating + ".");
        in.close();
        out.close();

    }
}