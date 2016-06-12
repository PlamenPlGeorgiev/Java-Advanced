import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 20.5.2016 г..
 */
public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elementsToPush = sc.nextInt();
        int elToPop = sc.nextInt();
        int elX = sc.nextInt();
        sc.nextLine();
        String[] array = sc.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(Integer.parseInt(array[i]));
        }
        if (elToPop!=0) {
            for (int i = 1; i <= elToPop; i++) {
                stack.pop();
            }
        }
        if (stack.contains(elX)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println("0");
            } else {
                while (stack.size()!=1) {
                    stack.remove(Math.max(stack.firstElement(),stack.lastElement()));
                }
                System.out.println(stack.pop());
            }
        }
    }
}
