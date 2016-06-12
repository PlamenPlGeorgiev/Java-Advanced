import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by admin on 24.5.2016 г..
 */
public class _01_UniqueUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> list = new LinkedHashSet<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
