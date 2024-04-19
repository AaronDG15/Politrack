package src.components;
import components.map.*;;
public abstract class PolitrackSecondary implements Politrack {


    public String getProjectedWinner() {
        Map<String, Integer> winCalc = new Map1L<>();
        Map<String, String> participants = this.getAllCandidates();
        Map<Double, String> data = this.getAllPolls();

        assert participants.size() != 0: "Violation of candidates is one or more";
        assert data.size() != 0: "Violation of polls is one or more";

        for(Map.Pair<String, String> y: participants) {
            String temp = y.key();
            winCalc.add(temp, 0);
        }
        for(Map.Pair<Double, String> z: data) {
            String temp = z.value();
            Map.Pair<String, Integer> cand = winCalc.remove(temp);
            winCalc.add(temp, cand.value() + 1);
        }
        int largest = 0;
        String winner = null;
        for(Map.Pair<String, Integer> a: winCalc) {
            if(a.value() > largest) {
                largest = a.value();
                winner = a.key();
            }
        }
        return winner;
    }


    public Double getPollAverage() {
        String winner = this.getProjectedWinner();
        Map<Double, String> data = this.getAllPolls();

        assert data.size() != 0: "Violation of polls is one or more";

        int counter = 0;
        Double preAvg = 0.0;
        for(Map.Pair<Double, String> y: data) {
            if(y.value().equals(winner)) {
                preAvg += y.key();
                counter++;
            }
        }
        Double avg = preAvg / counter;
        return avg;
    }


    public String giveRating() {
        Double avg = this.getPollAverage();
        String rate = null;
        if(avg < 10) {
            if(avg < 5) {
                if(avg < 1) {
                    rate = "tossup";
                } else {
                    rate = "lean";
                }
            } else {
               rate = "likely";
            }
        } else {
            rate = "safe";
        }
        return rate;
    }


    public String toString() {
        String winner = this.getProjectedWinner();
        String submit = winner + " is the winner, here's their margins: ";
        for(Map.Pair<Double, String> y: this.getAllPolls()) {
            if(y.value().equals(winner)) {
                submit += y.key();
                submit += " ";
            }
        }
        return submit;
    }


    public boolean equals(Object x) {
        boolean result = true;
        if(x == null) {
            result = false;
        }
        if(x.getClass() != this.getClass()) {
            result = false;
        }
        final Politrack temp = (Politrack)x;
        if((this.getRace() == null) ? (temp.getRace() != null) : !this.getRace().equals(temp.getRace())) {
            result = false;
        }
        if(!this.getAllPolls().equals(temp.getAllPolls())) {
            result = false;
        }
        if(!this.getAllCandidates().equals(temp.getAllCandidates())) {
            result = false;
        }
        return result;
    }


}


