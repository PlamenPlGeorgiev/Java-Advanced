import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _11_Palindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("[\\s,\\.\\?!]+");

        List<String> tokens = new ArrayList<>();
        List<String> repeaters = new ArrayList<>();
        for (String s : input) {
            StringBuilder check = new StringBuilder(s);
            if (repeaters.contains(s)) {
                continue;
            }
            if (tokens.contains(s)) {
                tokens.remove(s);
                repeaters.add(s);
            }
            StringBuilder reverse = new StringBuilder(s);
            reverse.reverse();
            if (check.toString().equals(reverse.toString())) {
                tokens.add(s);
            }
        }
        tokens.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(tokens);
    }
}
