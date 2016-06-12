import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 7.6.2016 г..
 */
public class _02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern firstPattern = Pattern.compile("(\\s|^)(\\+359[-][\\d][-][\\d]{3}[-][\\d]{4}\\b)");
        Pattern secondPattern = Pattern.compile("(\\s|^)(\\+359[ ][\\d][ ][\\d]{3}[ ][\\d]{4})\\b");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            Matcher firstMatcher = firstPattern.matcher(input);
            Matcher secondMatcher = secondPattern.matcher(input);
            if (firstMatcher.find()) {
                System.out.println(firstMatcher.group(2));
            }
            if (secondMatcher.find()) {
                System.out.println(secondMatcher.group(2));
            }
        }
    }
}
