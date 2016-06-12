import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 6.6.2016 г..
 */
public class _01_MatchFullName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            Pattern pattern = Pattern.compile("^(\\b[A-Z][a-z]+[ ][A-Z][a-z]+\\b)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group(1));
            } else {
                continue;
            }
        }
    }
}