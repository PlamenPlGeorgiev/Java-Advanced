import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _06_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        String substring = sc.nextLine().toLowerCase();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(substring,i)==i) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
