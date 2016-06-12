import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 19.5.2016 г..
 */
public class _01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String[] array = sc.nextLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            stack.add(Integer.parseInt(array[i]));
        }
        while (stack.size()>0) {
            System.out.print(stack.pop()+" ");
        }

    }
}
