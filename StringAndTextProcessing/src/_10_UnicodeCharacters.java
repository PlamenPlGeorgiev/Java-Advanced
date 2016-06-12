import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _10_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (char c : input.toCharArray()) {
            System.out.print(UnicodeEscaped(c));
        }
        System.out.println();
    }
    public static String UnicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }
}
