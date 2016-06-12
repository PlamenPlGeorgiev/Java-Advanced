import java.util.*;

/**
 * Created by admin on 3.6.2016 г..
 */
public class _17_LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, ArrayList<String>> mapLists1 = new TreeMap<>();
        Map<Integer, ArrayList<String>> mapLists2 = new TreeMap<>();
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < n; i++) {
            mapLists1.put(i, new ArrayList<>());
            mapLists2.put(i + n, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split("\\s+");
            for (String s : arr) {
                if (!s.equals("")) {
                    mapLists1.get(i).add(s);
                    counter1++;
                }
            }
        }
        for (int i = n; i < 2 * n; i++) {
            String[] arr = sc.nextLine().split("\\s+");
            for (String s : arr) {
                if (!s.equals("")) {
                    mapLists2.get(i).add(s);
                    counter2++;
                }
            }
        }
        int count = mapLists1.get(0).size() + mapLists2.get(n).size();
        Boolean allAreSameLength = true;
        for (int i = 0; i < n; i++) {
            if (mapLists1.get(i).size() + mapLists2.get(i + n).size() != count) {
                allAreSameLength = false;
                break;
            }
        }
        if (!allAreSameLength) {
            System.out.printf("The total number of cells is: %d", counter1 + counter2);
        } else {
            for (int i = 0; i < n; i++) {
                Collections.reverse(mapLists2.get(i + n));
                mapLists1.get(i).addAll(mapLists2.get(i + n));
                System.out.println(mapLists1.get(i));
            }
        }
    }
}
