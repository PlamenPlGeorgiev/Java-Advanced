import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 25.5.2016 г..
 */
public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> minerals = new LinkedHashMap<>();
        while (true) {
            String text = sc.nextLine();
            if (text.equals("stop")) {
                break;
            }
            int quantity = sc.nextInt();
            sc.nextLine();
            if (!minerals.containsKey(text)) {
                minerals.put(text, quantity);
            } else {
                minerals.put(text, minerals.get(text) + quantity);
                continue;
            }
        }
        for (String s : minerals.keySet()) {
            System.out.printf("%s -> %d%n", s, minerals.get(s));
        }
    }
}

