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
        System.arraycopy(items, 0, a, 0, nextFirst);
        System.arraycopy(items, nextFirst, a,
                a.length - items.length + nextFirst, items.length - nextFirst);
        nextFirst = a.length - items.length + nextFirst;
        items = a;
    }

    /** 在items的前面添加item */
    public void addFirst(T item) {
        size += 1;
        if (nextFirst == nextLast) {
            resize(2 * size);
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
            resize(2 * size);
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

    /** 打印items的所有内容
    public void printAll() {
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }
    */

    /** 打印nextFirst和nextLast
    public void printindex() {
        System.out.print(nextFirst + " ");
        System.out.print(nextLast + "\n");
    }
     */

    /** 删除items的第一个item */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
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

    /** 测试
    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        L.addFirst(0);
        L.addLast(1);
        L.addFirst(2);
        L.addLast(3);
        L.addFirst(4);
        L.addLast(5);
        L.addFirst(6);
        L.addLast(7);
        L.addFirst(8);
        L.addLast(9);
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.printDeque();
//        System.out.println(L.get(9));
    }
     */
}
