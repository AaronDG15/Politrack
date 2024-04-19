package test;
import src.components.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import components.map.*;


public class PolitrackKernalTest {

    @Test
    public void testConstructorsNoArgs() {
        Politrack one = new Politrack1();
        Politrack two = new Politrack1();
        assertEquals(true, one.equals(two));
    }

    @Test
    public void testConstructorsArgs() {
        Politrack one = new Politrack1("Senate");
        Politrack two = new Politrack1("Senate");
        assertEquals(true, one.equals(two));
    }

    @Test
    public void testConstructorsBoth() {
        Politrack one = new Politrack1();
        Politrack two = new Politrack1("Not Specified");
        assertEquals(true, one.equals(two));
    }

    @Test
    public void testAddCandidatesFromEmpty() {
        Politrack x = new Politrack1();
        boolean didAdd = true;
        x.addCandidates("John Doe", "Republican");
        try {
            String y = x.getCandidate("Republican").key();
            if(!y.equals("John Doe")) {
                didAdd = false;
            }
        } catch (Exception e) {
            didAdd = false;
        }
        assertEquals(true, didAdd);
    }

    @Test
    public void testAddCandidatesFew() {
        Politrack x = new Politrack1();
        boolean didAdd = true;
        x.addCandidates("John Doe", "Republican");
        x.addCandidates("Jane Doe", "Democratic");
        try {
            String y = x.getCandidate("Republican").key();
            if(!y.equals("John Doe")) {
                didAdd = false;
            }
        } catch (Exception e) {
            didAdd = false;
        }
        try {
            String y = x.getCandidate("Democratic").key();
            if(!y.equals("Jane Doe")) {
                didAdd = false;
            }
        } catch (Exception e) {
            didAdd = false;
        }
        assertEquals(true, didAdd);
    }


    @Test
    public void testAddCandidatesDuplicates() {
        Politrack x = new Politrack1();
        x.addCandidates("John Doe", "Republican");
        boolean z = false;
        try {
            x.addCandidates("John Doe", "Republican");
        } catch (AssertionError e) {
            z = true;
        }
        assertEquals(true, z);

    }

    @Test
    public void testGetCandidatePullOneHasOne() {
        Politrack x = new Politrack1();
        x.addCandidates("John Doe", "Republican");
        Map.Pair<String, String> actual = x.getCandidate("Republican");
        Map<String, String> e = new Map1L<>();
        e.add("John Doe", "Republican");
        Map.Pair<String, String> expected = e.remove("John Doe");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCandidatePullOneHasMore() {
        Politrack x = new Politrack1();
        x.addCandidates("Jane Doe", "Democratic");
        x.addCandidates("John Doe", "Republican");
        Map.Pair<String, String> actual = x.getCandidate("Republican");
        Map<String, String> e = new Map1L<>();
        e.add("John Doe", "Republican");
        Map.Pair<String, String> expected = e.remove("John Doe");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCandidateEmpty() {
        Politrack x = new Politrack1();
        boolean z = false;
        try {
            x.getCandidate("Bull Moose");
        } catch (AssertionError e) {
            z = true;
        }
        assertEquals(true, z);
    }

    @Test
    public void testGetCandidateDoesntHaveIt() {
        Politrack x = new Politrack1();
        x.addCandidates("Jane Doe", "Democratic");
        boolean z = false;
        try {
            x.getCandidate("Bull Moose");
        } catch (AssertionError e) {
            z = true;
        }
        assertEquals(true, z);
    }

    @Test
    public void testGetAllCandidatesEmpty() {
        Politrack x = new Politrack1();
        Map<String, String> expected = new Map1L<>();
        Map<String, String> actual = x.getAllCandidates();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllCandidatesHasOne() {
        Politrack x = new Politrack1();
        x.addCandidates("John Doe", "Republican");
        Map<String, String> expected = new Map1L<>();
        expected.add("John Doe", "Republican");
        Map<String, String> actual = x.getAllCandidates();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllCandidatesHasSome() {
        Politrack x = new Politrack1();
        x.addCandidates("John Doe", "Republican");
        x.addCandidates("RFK Jr.", "Independant");
        x.addCandidates("Jill Stien", "Green");
        Map<String, String> expected = new Map1L<>();
        expected.add("John Doe", "Republican");
        expected.add("RFK Jr.", "Independant");
        expected.add("Jill Stien", "Green");
        Map<String, String> actual = x.getAllCandidates();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllPollsEmpty() {
        Politrack x = new Politrack1();
        Map<Double, String> expected = new Map1L<>();
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllPollsOne() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllPollsHasSome() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        x.addPoll("John Doe", 13.6);
        x.addPoll("Mike Johnson", 0.5);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        expected.add(13.6, "John Doe");
        expected.add(0.5, "Mike Johnson");
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddPollEmpty() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);


    }

    @Test
    public void testAddPollHasOne() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        x.addPoll("RFK Jr.", 15.0);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        expected.add(15.0, "RFK Jr.");
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddPollHasSome() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        x.addPoll("John Doe", 13.6);
        x.addPoll("Mike Johnson", 0.5);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        expected.add(13.6, "John Doe");
        expected.add(0.5, "Mike Johnson");
        Map<Double, String> actual = x.getAllPolls();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollsHasOne() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        Map<Double, String> actual = x.getPolls("John Doe");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollsHasSome() {
        Politrack x = new Politrack1();
        x.addPoll("John Doe", 20.0);
        Map<Double, String> expected = new Map1L<>();
        expected.add(20.0, "John Doe");
        Map<Double, String> actual = x.getPolls("John Doe");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPollsNotContained() {
        Politrack x = new Politrack1();
        boolean z = false;
        try {
            x.getPolls("Fake Person");
        } catch (AssertionError e) {
            z = true;
        }
        assertEquals(true, z);
    }

    @Test
    public void testGetRace() {
        Politrack x = new Politrack1("Senate");
        assertEquals(true, x.getRace().equals("Senate"));
    }

    @Test
    public void testSetRace() {
        Politrack x = new Politrack1();
        x.setRace("Senate");
        assertEquals(true, x.getRace().equals("Senate"));
    }

    @Test
    public void testNewInstance() {
        Politrack x = new Politrack1();
        Politrack y = x.newInstance();
        assertEquals(x, y);
    }

    @Test
    public void testClear() {
        Politrack x = new Politrack1();
        Politrack y = x.newInstance();
        x.addCandidates("James", "Communist");
        x.addPoll("James", 12.3);
        x.clear();
        assertEquals(y, x);

    }

    @Test
    public void testTransferFrom() {
        Politrack x = new Politrack1();
        Politrack y = x.newInstance();
        Politrack z = x.newInstance();
        Politrack a = x.newInstance();
        x.addCandidates("RFK Jr.", "Independant");
        x.addCandidates("Joe Biden", "Democratic");
        x.addCandidates("Donald Trump", "Republican");
        z.addCandidates("RFK Jr.", "Independant");
        z.addCandidates("Joe Biden", "Democratic");
        z.addCandidates("Donald Trump", "Republican");
        y.transferFrom(x);
        assertEquals(y, z);
        assertEquals(x, a);

    }
}