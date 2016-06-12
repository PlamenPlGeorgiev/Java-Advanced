import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 20.5.2016 г..
 */
public class _3_MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            if (arr.length == 2) {
                stack.push(Integer.parseInt(arr[1]));
                if (max <= Integer.parseInt(arr[1])) {
                    max = Integer.parseInt(arr[1]);
                    maxStack.push(max);
                }
            } else if (arr.length == 1 && arr[0].equals("2")) {
                int poppedItem = stack.pop();
                if (poppedItem == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(max);
            }
        }
    }
}
