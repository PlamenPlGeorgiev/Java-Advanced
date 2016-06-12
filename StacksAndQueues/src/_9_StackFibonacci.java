import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by admin on 22.5.2016 г..
 */
public class _9_StackFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Long> stackFib = new ArrayDeque<>();
        stackFib.add((long) 1);
        stackFib.add((long) 1);
        int n = sc.nextInt();
        System.out.println();
        if (n <= 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {
                stackFib.add(stackFib.poll() + stackFib.peek());
            }
        }
        stackFib.poll();
        System.out.println(stackFib.poll());
    }
}
