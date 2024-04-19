package test;
import src.components.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PolitrackSecondaryTest {

    @Test
    public void testGetProjectedWinnerOneCandidateOnePoll() {

        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        String expected = "John Doe";
        String actual = testRace.getProjectedWinner();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetProjectedWinnerOneCandidatesTwoPolls() {

        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "John Doe";
        String actual = testRace.getProjectedWinner();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProjectedWinnerTwoCandidatesFewPolls() {

        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "Jane Doe";
        String actual = testRace.getProjectedWinner();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProjectedWinnerPackedRace() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addCandidates("Jo Jorgenson", "Libertarian");
        testRace.addCandidates("Jill Stein", "Green");
        testRace.addPoll("Jill Stein", 0.8);
        testRace.addPoll("Jo Jorgenson", 1.2);
        testRace.addPoll("Jo Jorgenson", 12.4);
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "Jane Doe";
        String actual = testRace.getProjectedWinner();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollAverageOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        Double expected = 20.0;
        Double actual = testRace.getPollAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollAverageTwoOneCandidate() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        testRace.addPoll("John Doe", 10.0);
        Double expected = 15.0;
        Double actual = testRace.getPollAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollAverageFewTwoCandidate() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("John Doe", 20.0);
        testRace.addPoll("John Doe", 10.0);
        Double expected = 15.0;
        Double actual = testRace.getPollAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollAverageFewOneCandidate() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 2.5);
        testRace.addPoll("John Doe", 3.0);
        Double expected = 8.875;
        Double actual = testRace.getPollAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollAveragePackedRace() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addCandidates("Jo Jorgenson", "Libertarian");
        testRace.addCandidates("Jill Stein", "Green");
        testRace.addPoll("Jill Stein", 0.8);
        testRace.addPoll("Jo Jorgenson", 1.2);
        testRace.addPoll("Jo Jorgenson", 12.4);
        testRace.addPoll("Jane Doe", 6.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        Double expected = 7.0;
        Double actual = testRace.getPollAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingTossupOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 0.5);
        String expected = "tossup";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingLeanOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 2.4);
        String expected = "lean";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingLikelyOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 6.8);
        String expected = "likely";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingSafeOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 23.6);
        String expected = "safe";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingRegularRace() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "likely";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testGiveRatingPackedRace() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addCandidates("Jo Jorgenson", "Libertarian");
        testRace.addCandidates("Jill Stein", "Green");
        testRace.addPoll("Jill Stein", 0.8);
        testRace.addPoll("Jo Jorgenson", 1.2);
        testRace.addPoll("Jo Jorgenson", 12.4);
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "likely";
        String actual = testRace.giveRating();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringOne() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        String expected = "John Doe is the winner, here's their margins: 20.0 ";
        String actual = testRace.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringTwo() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "Jane Doe is the winner, here's their margins: 1.8 5.0 13.2 ";
        String actual = testRace.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringPackedRace() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addCandidates("Jane Doe", "Third Way");
        testRace.addCandidates("Jo Jorgenson", "Libertarian");
        testRace.addCandidates("Jill Stein", "Green");
        testRace.addPoll("Jill Stein", 0.8);
        testRace.addPoll("Jo Jorgenson", 1.2);
        testRace.addPoll("Jo Jorgenson", 12.4);
        testRace.addPoll("Jane Doe", 5.0);
        testRace.addPoll("Jane Doe", 1.8);
        testRace.addPoll("Jane Doe", 13.2);
        testRace.addPoll("John Doe", 10.0);
        testRace.addPoll("John Doe", 20.0);
        String expected = "Jane Doe is the winner, here's their margins: 1.8 5.0 13.2 ";
        String actual = testRace.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsTrue() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        Politrack1 testRace2 = new Politrack1("Test race");
        testRace2.addCandidates("John Doe", "Alaskan Independance");
        testRace2.addPoll("John Doe", 20.0);
        boolean expected = true;
        boolean actual = testRace.equals(testRace2);
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFalseSameObject() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        Politrack1 testRace2 = new Politrack1("Test race");
        testRace2.addCandidates("Jane Doe", "Third Way");
        testRace2.addPoll("Jane Doe", 20.0);
        boolean expected = false;
        boolean actual = testRace.equals(testRace2);
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFaseDifferentObject() {
        Politrack1 testRace = new Politrack1("Test race");
        testRace.addCandidates("John Doe", "Alaskan Independance");
        testRace.addPoll("John Doe", 20.0);
        Object temp = 32;
        boolean expected = false;
        boolean actual;
        try {
            actual = testRace.equals(temp);
        } catch (Exception e) {
            actual = false;
        }
        assertEquals(expected, actual);
    }



}