import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by admin on 24.5.2016 г..
 */
public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            for (String token : tokens) {
                set.add(token);
            }
        }
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
