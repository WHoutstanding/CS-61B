package Lecture1.Lecture1_2;

public class ArrayDemo {
    public static void main(String[] args) {
        /* Create an array of five integers. */
        int [] someArray = new int[5];
        someArray[0] = 3;
        someArray[1] = 4;

        for (int i = 0; i < 5; i++) {
            System.out.println(someArray[i]);
        }
    }
}
