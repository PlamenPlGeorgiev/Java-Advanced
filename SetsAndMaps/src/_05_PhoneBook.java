import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by admin on 24.5.2016 г..
 */
public class _05_PhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> phonebook = new TreeMap<>();
        String text = sc.nextLine();
        while (!text.equals("search")) {
            String[] tokens = text.split("-");
            phonebook.put(tokens[0], tokens[1]);
            text = sc.nextLine();
        }
        text = sc.nextLine();
        while (true) {
            if (text.equals("Stop") || text.equals("stop")) {
                break;
            }
            if (phonebook.containsKey(text)) {
                System.out.printf("%s -> %s%n", text, phonebook.get(text));
            } else {
                System.out.printf("Contact %s does not exist.%n", text);
            }
            text = sc.nextLine();
            if (text.equals("Stop") || text.equals("stop")) {
                break;
            }
        }
    }
}
