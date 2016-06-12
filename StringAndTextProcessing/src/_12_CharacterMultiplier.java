import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        String first = tokens[0];
        String second = tokens[1];
        int min = Math.min(first.length(), second.length());
        int max = Math.max(first.length(), second.length());
        int sum = 0;
        for (int i = 0; i < min; i++) {
            sum += (int) first.charAt(i) * (int) second.charAt(i);
        }
        if (max > min) {
            for (int i = min; i < max; i++) {
                if (first.length() > second.length()) {
                    sum += (int) first.charAt(i);
                } else {
                    sum += (int) second.charAt(i);
                }
            }
        }
        System.out.println(sum);
    }
}
