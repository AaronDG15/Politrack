package src.components;
import components.map.*;
import components.standard.*;

public interface PolitrackKernal extends Standard<Politrack> {

    /**
     * @param name
     *      Name of the Candidate being added to this.candidates
     * @param party
     *      Party of the Candidate vbeing added to this.party
     * @ensures *this.candidates + (name, party) = this.candidates
     * @updates this.candidates
    */
    void addCandidates(String name, String party);

    /**
     * @param affiliation
     *      party of the candidate you are trying to remove
     *
     * @requires this.candidates contains a pair such that pair.value() = affiliation
     * @returns a pair of the candidates name and party
     * @ensures Pair<String, String>.value() = affiliation
     */
    Map.Pair<String, String> getCandidate(String affiliation);

    /**
     * @returns this.candidate
     */
    Map<String, String> getAllCandidates();

    /**
     * @returns this.polls
     */
    Map<Double, String> getAllPolls();

    /**
     * @param winner
     *      Name of the winner in the poll
     * @param margin
     *      The margin of victory that the winner one by (winners percent - losers percent)
     * @ensures *this.polls + (winner, margin) = this.polls
     * @updates this.polls
     */
    void addPoll(String winner, Double margin);

    /**
     * @param winner
     *      The candidate whose winning polls you want
     * @requires winner is in #this.polls
     * @returns a map of all the polls containing the name of winner
     * @ensures each Pair<Doube, String> returned is in #this.polls
     * @updates this.polls so that it no longer contains the polls now contained in the returned map
     */
    Map<Double, String> getPolls(String winner);

    /**
     * @param raceType
     *      The type of race that is being ran i.e. House, Senate, President, etc.
     * @ensures this.race = raceType
     */
    void setRace(String raceType);

    /**
     * @returns this.race
     */
    String getRace();
}