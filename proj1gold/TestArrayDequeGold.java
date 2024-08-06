import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    /** Test the methods of class StudentArrayDequeLauncher. */
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> input1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> input2 = new ArrayDequeSolution<>();

        int N = 16;
        for (int i = 0; i < N; i += 1) {
            input1.addLast(i);
            input2.addLast(i);
            if (i % 2 != 0) {
                input1.removeFirst();
                input2.removeFirst();
            }
            int actual = input1.get(0);
            int expected = input2.get(0);
            assertEquals("\naddLast(" + i + ")" + "\n"
                    + "removeFirst(" + i + ")" + "\n"
                    + "removeFirst()", expected, actual);
        }
    }
}
