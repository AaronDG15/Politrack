package src.components;

public interface Politrack extends PolitrackKernal {

    /**
     * @return the name of the candidate who has the most polls saying they'll win
     * @ensures the returned value is the name value who has the most Pair.value() equal to their name
     */
    String getProjectedWinner();

    /**
     * @return the average of all of the margins with the winner determined by using getProjectedWinner
     * @ensures the returned value is equal to the average of all the keys in the map obtained by using getPolls(getProjectedWinner())
     */
    Double getPollAverage();

    /**
     * @return the "rating" of the race
     * @ensures the rating is calculated by getting getPollAverage and then seeing if its safe, likely, lean, or tossup
     */
    String giveRating();
}