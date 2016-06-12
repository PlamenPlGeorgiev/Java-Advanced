import java.util.*;

/**
 * Created by admin on 31.5.2016 г..
 */
public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> userDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIP = new TreeMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String ip = tokens[0];
            String name = tokens[1];
            Integer duration = Integer.parseInt(tokens[2]);
            if (!userDuration.containsKey(name)) {
                userDuration.put(name, 0);
            }
            userDuration.put(name, userDuration.get(name) + duration);
            if (!userIP.containsKey(name)) {
                userIP.put(name, new TreeSet<>());
            }
            userIP.get(name).add(ip);
        }
        userDuration.entrySet().stream()
                .forEach(entry -> {
                    String name = entry.getKey();
                    int duration = entry.getValue();
                    System.out.printf("%s: %d ", name, duration);
                    Set<String> ipList = userIP.get(name);
                    ipList.stream().sorted();
                    System.out.print(ipList);
                    System.out.println();
                });
    }
}
