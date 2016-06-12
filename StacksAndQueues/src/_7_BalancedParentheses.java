import java.util.*;

/**
 * Created by admin on 21.5.2016 г..
 */
public class _7_BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String symbols = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        Deque<Character> queue = new ArrayDeque<>();
        int counter = 0;
        for (int i = 0; i < symbols.length() - 1; i++) {
            if ((symbols.charAt(i) == '(' && symbols.charAt(i + 1) == ')')
                    || (symbols.charAt(i) == '[' && symbols.charAt(i + 1) == ']')
                    || (symbols.charAt(i) == '{' && symbols.charAt(i + 1) == '}')) {
                i++;
                counter += 2;
                continue;
            }
            stack.add(symbols.charAt(i));
            queue.add(symbols.charAt(i));
        }
        if (counter == symbols.length()) {
            System.out.println("YES");
        } else {
            stack.add(symbols.charAt(symbols.length() - 1));
            queue.add(symbols.charAt(symbols.length() - 1));
            if (stack.size() % 2 != 0) {
                System.out.println("NO");
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println("YES");
                        break;
                    }
                    if ((stack.peek().equals('}') && queue.peek().equals('{'))
                            || (stack.peek().equals(')') && queue.peek().equals('('))
                            || (stack.peek().equals(']') && queue.peek().equals('['))
                            || (stack.peek().equals('{') && queue.peek().equals('}'))
                            || (stack.peek().equals('(') && queue.peek().equals(')'))
                            || (stack.peek().equals('[') && queue.peek().equals(']'))) {
                        stack.pop();
                        queue.pop();
                    } else {
                        System.out.println("NO");
                        break;
                    }
                }
            }
        }
    }
}

