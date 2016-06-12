import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _09_TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(", ");
        StringBuilder text = new StringBuilder(sc.nextLine());
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.indexOf(tokens[i]) == j) {
                    StringBuilder replacer = new StringBuilder();
                    for (Character s : tokens[i].toCharArray()) {
                        replacer.append("*");
                    }
                    text.replace(j, j + tokens[i].length(), replacer.toString());
                }
            }
        }
        System.out.println(text);
    }
}
