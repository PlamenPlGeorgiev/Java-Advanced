import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Created by admin on 6.6.2016 г..
 */
public class _14_LetterChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split("\\s+");
        List<Character> uppercases = new ArrayList<>();
        uppercases.add(' ');
        uppercases.add('A');
        List<Character> lowercases = new ArrayList<>();
        lowercases.add(' ');
        lowercases.add('a');
        Double sum = 0d;
        for (int i = 2; i <= 26; i++) {
            uppercases.add((char) (uppercases.get(i - 1) + 1));
            lowercases.add((char) (lowercases.get(i - 1) + 1));
        }
        for (int i = 0; i < tokens.length; i++) {
            String input = tokens[i];
            char firstLetter = input.charAt(0);
            char lastLetter = input.charAt(input.length() - 1);
            Double number = Double.parseDouble(input.substring(1, input.length() - 1));
            if (uppercases.contains(firstLetter)) {
                number /= uppercases.indexOf(firstLetter);
            } else {
                number *= lowercases.indexOf(firstLetter);
            }
            if (uppercases.contains(lastLetter)) {
                number -= uppercases.indexOf(lastLetter);
            } else {
                number += lowercases.indexOf(lastLetter);
            }
            sum += number;
        }
        System.out.printf("%.2f%n", sum);
    }
}
