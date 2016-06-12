import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 23.5.2016 г..
 */
public class _11_PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int days = 0;
        Stack<Integer> plants = new Stack<>();
        for (int i = 0; i < n; i++) {
            plants.add(sc.nextInt());
        }
        while (true) {
            int counter = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < plants.size() - 1; i++) {
                if (plants.get(i) < plants.get(i + 1)) {
                    stack.push(i + 1);
                    counter++;
                }
            }
            if (counter == 0) {
                System.out.println(days);
                break;
            } else {
                days++;
            }
            for (int i = 0; i < counter; i++) {
                plants.removeElementAt(stack.pop());
            }
        }
    }
}
