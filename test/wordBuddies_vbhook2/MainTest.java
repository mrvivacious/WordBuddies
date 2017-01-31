package wordBuddies_vbhook2;

import org.junit.Test;

import static org.junit.Assert.*;
// ?? Add helper functions. Piazza post
/**
 * Created by vbhook2 on 1/23/17.
 */
public class MainTest {

    /**
     * Test for successful cases
     * @throws Exception
     */
    @Test
    public void buddies() throws Exception {
        String[] goodInput = {"scar", "feature", "fee", "tsarina"};
        assertEquals("ar fe fe ar", Main.isWordBuddies(goodInput));

        //Is this in the parameters? How do I solve for this situation? Works perfect without numbers
        String[] greatInput = {"S32CAT", "tH32aT", "mOuSe", "HoUSE"};
        assertEquals("32at 32at ouse ouse", Main.isWordBuddies(greatInput));
    }

    /**
     * Test for fail cases
     * @throws Exception
     */
    @Test
    public void notBuddies() throws Exception {
        String[] badInput = {"scar", "feature", "fee", "fear      "};
        assertEquals("Not Buddies", Main.isWordBuddies(badInput));

        String[] notGreatInput = {"scat", "that", "mouse"};
        assertEquals("Not Buddies", Main.isWordBuddies(notGreatInput));
    }

    /**
     * Test for other possible inputs
     * @throws Exception
     */
    @Test
    public void otherInputs() throws Exception {
        String[] usedAndAbusedInput = {"1", "2", "3", "2", "1", "3"};
        assertEquals( "Not Buddies", Main.isWordBuddies(usedAndAbusedInput));

        String[] emptyInput = {""};
        assertEquals("Not Buddies", Main.isWordBuddies(emptyInput));
    }

    /**
     * Test for edge cases
     * @throws Exception
     */
    @Test
    public void unlikelyInputs() throws Exception {
        String[] noInput = {};
        assertEquals("Not Buddies", Main.isWordBuddies(noInput));

        String[] nullInput = {null};
        assertEquals("Not Buddies", Main.isWordBuddies(nullInput));

        String[] newLine = {"\n"};
        assertEquals("Not Buddies", Main.isWordBuddies(newLine));
    }
}