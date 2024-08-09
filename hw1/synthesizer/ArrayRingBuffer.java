package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */

    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        fillCount += 1;
        rb[last++] = x;

        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue Oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        fillCount--;
        T x = rb[first];
        first++;
        if (first == capacity) {
            first = 0;
        }
        return x;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    public Iterator<T> iterator() {
        return new ArrayRingBufferiterator();
    }

    private class ArrayRingBufferiterator implements Iterator {
        private int index;
        private int cnt;
        public ArrayRingBufferiterator() {
            index = first;
            cnt = first;
        }

        @Override
        public boolean hasNext() {
            return cnt < first + fillCount;
        }

        @Override
        public T next() {
            T indexItem = rb[index];
            index += 1;
            cnt += 1;
            if (index == capacity) {
                index = 0;
            }
            return indexItem;
        }
    }

}
