import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 6.6.2016 г..
 */
public class _13_MagicExchangableWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        String first = tokens[0];
        String second = tokens[1];
        int min = Math.min(first.length(), second.length());
        int max = Math.max(first.length(), second.length());
        Map<Character, Character> chars = new HashMap<>();
        boolean isTrue = true;
        for (int i = 0; i < min; i++) {
            if (!chars.containsKey(first.charAt(i))) {
                chars.put(first.charAt(i), second.charAt(i));
            } else {
                if (!chars.get(first.charAt(i)).equals(second.charAt(i))) {
                    isTrue = !isTrue;
                    break;
                }
            }
        }
        if (!isTrue) {
            System.out.println(isTrue);
        } else if (isTrue && max > min) {
            for (int i = min; i < max; i++) {
                if (first.length() > second.length()) {
                    if (!chars.containsKey(first.charAt(i))) {
                        isTrue = !isTrue;
                        break;
                    }
                } else {
                    if (!chars.containsValue(second.charAt(i))) {
                        isTrue = !isTrue;
                        break;
                    }
                }
            }
            System.out.println(isTrue);
        } else if (isTrue && max == min) {
            System.out.println(isTrue);
        }
    }
}

