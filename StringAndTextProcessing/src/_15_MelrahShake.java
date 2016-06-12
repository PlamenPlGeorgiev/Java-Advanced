import java.util.Scanner;

/**
 * Created by admin on 9.6.2016 г..
 */
public class _15_MelrahShake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        while (true) {
            if (pattern.equals("")) {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            if (text.equals("")) {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            if (text.indexOf(pattern) == text.lastIndexOf(pattern)) {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            if (!text.contains(pattern)) {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            if (pattern.length() >= text.length() - 1 && text.length() > 2) {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            text = text.replaceFirst(pattern, "");

            StringBuilder buffText = new StringBuilder();
            StringBuilder buffPattern = new StringBuilder();

            buffText.append(text);
            buffText.reverse();
            buffPattern.append(pattern);
            buffPattern.reverse();

            text = buffText.toString();
            pattern = buffPattern.toString();

            text = text.replaceFirst(pattern, "");

            StringBuilder newText = new StringBuilder();
            StringBuilder newPattern = new StringBuilder();

            text = newText.append(text).reverse().toString();
            pattern = newPattern.append(pattern)
                    .reverse()
                    .replace(newPattern.length() / 2, newPattern.length() / 2 + 1, "")
                    .toString();
            System.out.println("Shaked it.");
        }
    }
}
