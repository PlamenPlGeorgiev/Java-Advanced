import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 21.5.2016 г..
 */
public class _6_TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Queue<Integer> petrol = new ArrayDeque<>();
        Queue<Integer> distance = new ArrayDeque<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            petrol.add(sc.nextInt());
            distance.add(sc.nextInt());
            sc.nextLine();
        }
        while (true) {
            Queue<Integer> newPetrol = new ArrayDeque<>();
            Queue<Integer> newDistance = new ArrayDeque<>();
            newPetrol.addAll(petrol);
            newDistance.addAll(distance);
            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += newPetrol.poll();
                sum2 += newDistance.poll();
                if (sum1 < sum2) {
                    break;
                }
            }
            if (sum1 < sum2) {
                petrol.add(petrol.poll());
                distance.add(distance.poll());
                counter++;
            } else {
                break;
            }
        }
        System.out.println(counter);
    }
}
