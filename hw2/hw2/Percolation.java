package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    boolean[][] st;
    WeightedQuickUnionUF uf;

    private int[] dx = new int[]{0, 1, 0, -1};
    private int[] dy = new int[]{-1, 0, 1, 0};
    private int size;

    /** Create N-by-N grid, with all sites initially blocked. */
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        st = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N);
        size = N;
    }

    /** Returns the number of index. */
    private int getNumber(int r, int c) {
        return r * size + c;
    }

    /** Check. */
    private boolean check(int r, int c) {
        if (r < 0 || r >= size || c < 0 || c >= size) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    /** Open the site (row, col) if it is not open already. */
    public void open(int row, int col) {
        check(row, col);

        st[row][col] = true;
        int number = getNumber(row, col);
        for (int i = 0; i < 4; i++) {
            int r = row + dx[i], c = col + dy[i];
            if (r >= 0 && r < size && c >= 0 && c < size) {
                int subNumber = getNumber(r, c);
                uf.union(number, subNumber);
            }
        }
    }

    /** Is the site (row, col) open? */
    public boolean isOpen(int row, int col) {
        check(row, col);
        return st[row][col];
    }

    /** Is the site (row, col) full? */
    public boolean isFull(int row, int col) {
        check(row, col);

        int indexNumber = getNumber(row, col);
        for (int i = 0; i < size; i++) {
            int number = getNumber(0, i);
            if (uf.connected(number, indexNumber)) {
                return true;
            }
        }
        return false;
    }

    /** number of open sites. */
    public int numberOfOpenSites() {
        int number = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (st[i][j]) {
                    number++;
                }
            }
        }
        return number;
    }

    /** does the system percolate? */
    public boolean percolates() {
        for (int j = 0; j < size; j++) {
            if (isFull(size - 1, j)) {
                return true;
            }
        }
        return false;
    }

    /** use for unit testing (not required).
    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        uf.union(0, 1);
        uf.union(0, 9);
        System.out.println(uf.connected(0, 9));
    } */
}
