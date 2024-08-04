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
    }

    // Your tests go here.
    /** Uncomment this class once you've created your CharacterComparator interface and OffByOne class. */
}
