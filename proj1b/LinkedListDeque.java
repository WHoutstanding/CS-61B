/** Deque */
public class LinkedListDeque<T> implements Deque<T> {

    /** Node */
    private class Node {
        Node prev;
        T item;
        Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentFront;
    private int size;
    private Node sentBack;

    /** Constructor */
    public LinkedListDeque() {
        sentBack = new Node(null, null, null);
        size = 0;
        sentFront = new Node(null, null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }

    /** Add item to the front of the Deque. */
    @Override
    public void addFirst(T item) {
        size += 1;
        Node n = new Node(null, item, null);
        n.prev = sentFront;
        n.next = sentFront.next;
        sentFront.next.prev = n;
        sentFront.next = n;
    }

    /** Add item to the last of the Deque. */
    @Override
    public void addLast(T item) {
        size += 1;
        Node n = new Node(null, item, null);
        n.next = sentBack;
        n.prev = sentBack.prev;
        sentBack.prev.next = n;
        sentBack.prev = n;
    }

    /** Is or is not empty. */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the size of Deque. */
    @Override
    public int size() {
        return size;
    }

    /** print all items of the Deque. */
    @Override
    public void printDeque() {
        Node q = sentFront;
        while (q.next.next != null) {
            q = q.next;
            System.out.print(q.item + " ");
        }
    }

    /** Remove the first node of the Deque and Reutrn its item
     * (if exists) else return null. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        size -= 1;
        T item = sentFront.next.item;
        sentFront.next.next.prev = sentFront;
        sentFront.next = sentFront.next.next;

        return item;
    }
    /** Remove the last node of the Deque and Reutrn its item
     * (if exists) else return null. */
    @Override
    public T removeLast() {
        if (isEmpty())  {
            return null;
        }

        size -= 1;
        T item = sentBack.prev.item;
        sentBack.prev.prev.next = sentBack;
        sentBack.prev = sentBack.prev.prev;

        return item;
    }

    /** Returns the ith item of the List. */
    @Override
    public T get(int idex) {
        if (isEmpty()) {
            return null;
        }

        if (idex < 0 || idex >= size)  {
            return null;
        }

        Node q = sentFront;
        int cnt = 0;
        while (q.next.next != null) {
            q = q.next;
            if (cnt == idex) {
                break;
            }
            cnt += 1;
        }

        return q.item;
    }

    private T getRecursive(int cnt, int idex, Node n) {
        if (cnt == idex) {
            return n.item;
        }

        return getRecursive(cnt + 1, idex, n.next);
    }


    public T getRecursive(int idex) {
        if (isEmpty()) {
            return null;
        }

        if (idex < 0 || idex >= size) {
            return null;
        }

        return getRecursive(0, idex, sentFront.next);
    }

}
