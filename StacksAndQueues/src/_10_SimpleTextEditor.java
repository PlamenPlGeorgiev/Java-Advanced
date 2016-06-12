import java.util.Scanner;
import java.util.Stack;

/**
 * Created by admin on 23.5.2016 г..
 */
public class _10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> textStack = new Stack<>();
        Stack<String> commandStack = new Stack<>();
        Stack<String> deletedStack = new Stack<>();
        int n = sc.nextInt();
        sc.nextLine();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("1")) {
                textStack.push(tokens[1]);
                text.append(tokens[1]);
                commandStack.push(tokens[0]);
            } else if (tokens[0].equals("2")) {
                deletedStack.push(text.substring(text.length()-Integer.parseInt(tokens[1]),text.length()));
                text.delete(text.length()-Integer.parseInt(tokens[1]),text.length());
                commandStack.push(tokens[0]);
            } else if (tokens[0].equals("3")) {
                int charIndex = Integer.parseInt(tokens[1])-1;
                System.out.println(text.charAt(charIndex));
            } else if (tokens[0].equals("4")) {
                String commandToUndo = commandStack.pop();
                if (commandToUndo.equals("1")) {
                    text.delete(text.length()-textStack.pop().length(),text.length());
                } else if (commandToUndo.equals("2")) {
                    text.append(deletedStack.pop());
                }
            }
        }
    }
}
