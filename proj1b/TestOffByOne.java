import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        char input1 = 'a', input2 = 'b';
        boolean expected1 = true;
        boolean actual1 = offByOne.equalChars(input1, input2);
        assertEquals(actual1, expected1);

        char input3 = 'a', input4 = 'a';
        boolean expected2 = false;
        boolean actual2 = offByOne.equalChars(input3, input4);
        assertEquals(actual2, expected2);

        char input5 = 'a', input6 = 'B';
        boolean expected3 = false;
        boolean actual3 = offByOne.equalChars(input5, input6);
        assertEquals(actual3, expected3);

        char input7 = '&', input8 = '%';
        boolean expected4 = true;
        boolean actual4 = offByOne.equalChars(input7, input8);
        assertEquals(actual4, expected4);
    }

    // Your tests go here.
    /** Uncomment this class once you've created your CharacterComparator interface and OffByOne class. */
}
