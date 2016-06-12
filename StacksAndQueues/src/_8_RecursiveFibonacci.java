import java.util.Scanner;

/**
 * Created by admin on 22.5.2016 г..
 */
public class _8_RecursiveFibonacci {
    public static long[] fibArray = new long[50];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFibonacci(n));
    }

    static Long getFibonacci(int n) {
        fibArray[0] = 1;
        fibArray[1] = 1;
        if (n <= 1) {
            return (long) 1;
        } else if (fibArray[(int) n] != 0) {
            return fibArray[(int) n];
        } else {
            fibArray[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
