import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 25.5.2016 г..
 */
public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new LinkedHashMap<>();
        while (true) {
            String name = sc.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = sc.nextLine();
            if (email.substring(email.length()-2,email.length()).equals("uk")
                    || email.substring(email.length()-2,email.length()).equals("us")) {
                continue;
            } else {
                map.put(name,email);
            }
        }
        for (String s : map.keySet()) {
            System.out.printf("%s -> %s%n",s, map.get(s));
        }
    }
}
