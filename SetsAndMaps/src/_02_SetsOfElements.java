import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by admin on 24.5.2016 г..
 */
public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> firstSet = new TreeSet<>();
        Set<Integer> secondSet = new TreeSet<>();
        int firstSetLength = sc.nextInt();
        int secondSetLength = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(sc.nextInt());
        }
        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(sc.nextInt());
        }
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                System.out.print(integer + " ");
            }
        }
    }
}
