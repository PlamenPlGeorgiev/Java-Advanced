import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by admin on 20.5.2016 г..
 */
public class _4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int enqueue = sc.nextInt();
        int dequeue = sc.nextInt();
        int elX = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        sc.nextLine();
        String[] nums = sc.nextLine().split(" ");
        for (int i = 0; i < enqueue; i++) {
            queue.add(Integer.parseInt(nums[i]));
        }
        for (int i = 0; i < dequeue; i++) {
            queue.poll();
        }
        if (queue.contains(elX)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            int min = Integer.MAX_VALUE;
            for (Integer num : queue) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println(min);
        }
    }
}
