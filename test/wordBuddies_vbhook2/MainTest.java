package wordBuddies_vbhook2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vbhook2 on 1/23/17.
 */
public class MainTest {
    @Test
    public void buddies() throws Exception {
        String[] goodInput = {"scar", "feature", "fee", "tsarina"};
        assertEquals("ar fe fe ar", Main.isWordBuddies(goodInput));

        String[] greatInput = {"SCAT", "tHaT", "mOuSe", "HoUSE"};
        assertEquals("at at ouse ouse", Main.isWordBuddies(greatInput));
    }

    @Test
    public void notBuddies() throws Exception {
        String[] badInput = {"scar", "feature", "fee", "fear"};
        assertEquals("Not Buddies", Main.isWordBuddies(badInput));

        String[] notGreatInput = {"scat", "that", "mouse"};
        assertEquals("Not Buddies", Main.isWordBuddies(notGreatInput));
    }

    @Test
    public void otherInputs() throws Exception {
        String[] usedAndAbusedInput = {"1", "2", "3", "2", "1", "3"};
        assertEquals( "Not Buddies", Main.isWordBuddies(usedAndAbusedInput));

        String[] noInput = {""};
        assertEquals("Not Buddies", Main.isWordBuddies(noInput));

        String[] nullInput = {null};
        assertEquals("Not Buddies", Main.isWordBuddies(nullInput));
    }

    @Test
    public void noInput() throws Exception {
        String[] noInput = {};
        assertEquals("Not Buddies", Main.isWordBuddies(noInput));
    }
}