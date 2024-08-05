import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String input1 = "flake";
        boolean expected1 = true;
        CharacterComparator cc = new OffByOne();
        boolean actual1 = palindrome.isPalindrome(input1, cc);
        assertEquals(actual1, expected1);

        String input2 = "a";
        boolean expected2 = true;
        boolean actual2 = palindrome.isPalindrome(input2, cc);
        assertEquals(actual2, expected2);

        String input3 = "";
        boolean expected3 = true;
        boolean actual3 = palindrome.isPalindrome(input3, cc);
        assertEquals(actual3, expected3);

        String input4 = "Flake";
        boolean expected4 = false;
        boolean actual4 = palindrome.isPalindrome(input4, cc);
        assertEquals(actual4, expected4);
    }

    @Test
    public void testIsPalindromeN() {
        String input1 = "flake";
        boolean expected1 = true;
        CharacterComparator cc = new OffByN(1);
        boolean actual1 = palindrome.isPalindrome(input1, cc);
        assertEquals(actual1, expected1);

        String input2 = "a";
        boolean expected2 = true;
        boolean actual2 = palindrome.isPalindrome(input2, cc);
        assertEquals(actual2, expected2);

        String input3 = "";
        boolean expected3 = true;
        boolean actual3 = palindrome.isPalindrome(input3, cc);
        assertEquals(actual3, expected3);
    }


    /** Uncomment this class once you've created your Palindrome class. */
}
