public class RotatingSLList<Item> extends SLList<Item> {

    /** Rotate list to the right. */
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }


    public static void main(String[] args) {
        RotatingSLList<Integer> L = new RotatingSLList<>();
        L.addLast(0);
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.rotateRight();
        L.print();
    }
}

