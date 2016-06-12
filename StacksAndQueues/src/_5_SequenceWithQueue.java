import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 20.5.2016 г..
 */
public class _5_SequenceWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.add(n);
        queue.add(n + 1);
        queue.add(2 * n + 1);
        ArrayList<Long> sequence = new ArrayList<>();
        sequence.add((long) 0);
        int currnum = 2;
        sequence.add(n);
        sequence.add(n + 1);
        sequence.add(2 * n + 1);
        while (true) {
            queue.add(sequence.get(currnum - 1) + 2);
            sequence.add(sequence.get(currnum - 1) + 2);
            if (queue.size() == 50) {
                break;
            }
            queue.add(sequence.get(currnum) + 1);
            sequence.add(sequence.get(currnum) + 1);
            if (queue.size() == 50) {
                break;
            }
            queue.add(2 * sequence.get(currnum) + 1);
            sequence.add(2 * sequence.get(currnum) + 1);
            if (queue.size() == 50) {
                break;
            }
            currnum++;
        }
        for (Long q : queue) {
            System.out.print(q + " ");
        }
    }
}
