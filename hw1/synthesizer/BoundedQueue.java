package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    /** Return the size of buffer. */
    int capacity();

    /** Returns number of items currently in the buffer. */
    int fillCount();

    /** Adds item to the end. */
    void enqueue(T x);

    /** Deletes and Returns item from the front. */
    T dequeue();

    /** Returns (but do not delete) item from the front. */
    T peek();

    /** Is the buffer empty (fillCount equals zero?). */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /** Is the buffer full? */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
