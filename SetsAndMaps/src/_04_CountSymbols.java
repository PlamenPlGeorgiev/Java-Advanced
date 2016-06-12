import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by admin on 24.5.2016 г..
 */
public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new TreeMap<>();
        char[] text = sc.nextLine().toCharArray();
        for (char c : text) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : map.keySet()) {
            System.out.printf("%s: %d time/s%n", c, map.get(c));
        }
    }
}
