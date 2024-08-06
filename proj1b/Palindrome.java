public class Palindrome {
    /** Returns a Deque including Character of word. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            q.addLast(word.charAt(i));
        }
        return q;
    }

    public boolean isPalindrome(String word) {
        if (word == null) return true;
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            char a = word.charAt(i), b = word.charAt(len - 1 - i);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) return true;
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            char a = word.charAt(i), b = word.charAt(len - 1 - i);
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }
}
