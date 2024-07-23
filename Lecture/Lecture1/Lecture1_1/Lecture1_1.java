public class Lecture1_1 {

//    public static void main(String[] args) {
//        System.out.println("Hello World");
//    }
//    public static void main(String[] args) {
//        int x = 0;
//        while(x < 10) {
//            System.out.println(x);
//            x = x + 1;
//        }
//    }
//    public static void main(String[] args) {
//        int x = 0, sum = 0;
//        while(x < 10) {
//            sum += x;
//            x = x + 1;
//        }
//        System.out.println(sum);
//    }
/*    public static void main(String[] args) {
        String h = 5 + "horse";
        System.out.println(h);
    }
*/
/*    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(larger(1, 2));
    }
 */
//    public static int mystery(int[] inputArray, int k) {
//        int x = inputArray[k];
//        int answer = k;
//        int index = k + 1;
//        while (index < inputArray.length) {
//            if(inputArray[index] < x) {
//                x = inputArray[index];
//                answer = index;
//            }
//            index = index + 1;
//        }
//        return answer;
//    }
/*

    public static void main(String[] args) {
        int[] a = {3, 0, 4, 6, 3};
        int k = 2;
        System.out.println(mystery(a, k));
    }
 */

//    public static void mystery2(int[] inputArray) {
//        int index = 0;
//        while(index < inputArray.length) {
//            int targetIndex = mystery(inputArray, index);
//            int temp = inputArray[targetIndex];
//            inputArray[targetIndex] = inputArray[index];
//            inputArray[index] = temp;
//            index = index + 1;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] a = {3, 0, 4, 6, 3};
//        int k = 2;
//        mystery2(a);
//        for(int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//    }

//    public static int fib(int n) {
//        if (n == 1) return 0;
//        if (n == 2) return 1;
//
//        int index = 2, f1 = 0, f2 = 1, f3 = f1 + f2;
//        while (index < n) {
//            f3 = f1 + f2;
//            f1 = f2;
//            f2 = f3;
//            index = index + 1;
//        }
//        return f3;
//    }
    public static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n - 2);
    }
    public static int fib2(int n, int k, int f0, int f1) {
        if(n == k) {
            return f0;
        }else {
            return fib2(n, k+1, f1, f0+f1);
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(fib(i));
        }
    }
}
