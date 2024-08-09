package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(5);
        arb.enqueue(0);
        arb.dequeue();
        arb.enqueue(1);
        arb.dequeue();
        arb.enqueue(2);
        arb.dequeue();
        arb.enqueue(3);
        arb.dequeue();
        arb.enqueue(4);
        arb.dequeue();

        for (Integer i : arb) {
            System.out.println(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
