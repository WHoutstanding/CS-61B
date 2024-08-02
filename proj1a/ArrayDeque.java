public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** 初始化ArrayDeque */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** 增大items的大小 */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int index = 0;
        for (int i = nextFirst + 1; ;i++) {
            if (i == items.length) {
                i = 0;
            }
            if (i == nextLast) break;

            a[index++] = items[i];
        }

        nextFirst = a.length - 1;
        nextLast = index;

        items = a;
    }

    /** 在items的前面添加item */
    public void addFirst(T item) {
        size += 1;
        if (nextFirst == nextLast) {
            resize(2 * items.length);
        }

        items[nextFirst--] = item;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
    }

    /** 在items的后面添加item */
    public void addLast(T item) {
        size += 1;
        if (nextLast == nextFirst) {
            resize(2 * items.length);
        }

        items[nextLast++] = item;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    /** 判断items是否为空 */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** 返回items的大小 */
    public int size() {
        return size;
    }

    /** 从前到后打印items的内容*/
    public void printDeque() {
        for (int i = nextFirst + 1; i != nextLast; i++) {
            if (i == items.length) {
                i = 0;
            }
            System.out.print(items[i] + " ");
        }
    }

    /** print the length of items.*/
    private void printItemsLength() {
        System.out.println(items.length);
    }


    /** 判断items大小是否应该减小。 */
    private boolean checkSize() {
        if (items.length >= 16) {
            if (size * 1.0 / items.length < 0.25) {
                return true;
            }
        }
        return false;
    }

    /** 减小items。 */
    /**
    private void resizeDecrease(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int index = 0;
        for (int i = nextFirst + 1; i != nextLast; i++) {
            if (i == items.length) {
                i = 0;
            }
            a[index++] = items[i];
        }

        nextFirst = a.length - 1;
        nextLast = index;

        items = a;
    }
     */

    /** 删除items的第一个item */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        if (checkSize()) {
            resize(items.length / 2);
        }
        nextFirst++;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        return items[nextFirst];
    }

    /** 删除items的最后一个item */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        if (checkSize()) {
            resize(items.length / 2);
        }
        nextLast--;
        if (nextLast == -1) {
            nextLast = items.length - 1;
        }

        return items[nextLast];
    }

    /** 返回第index个item */
    public T get(int index) {
        if (size == 0) {
            return null;
        }
        return items[(index + 1 + nextFirst) % items.length];
    }

    /** Test
     * public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            L.addLast(i);
        }
        L.printDeque();
    }*/
}
