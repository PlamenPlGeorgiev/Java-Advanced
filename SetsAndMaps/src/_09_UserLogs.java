import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 26.5.2016 г..
 */
public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> userIPCount = new TreeMap<>();
        while (true) {
            String text = sc.nextLine();
            if (text.equals("end")) {
                break;
            }
            Pattern pattern = Pattern.compile("IP=(.*) message='.*?' user=(.*)");
            Matcher matcher = pattern.matcher(text);
            while (!matcher.find()) {
                continue;
            }
            String ip = matcher.group(1);
            String user = matcher.group(2);
            if (!userIPCount.containsKey(user)) {
                userIPCount.put(user, new LinkedHashMap<>());
            }
            if (!userIPCount.get(user).containsKey(ip)) {
                userIPCount.get(user).put(ip, 1);
            } else {
                userIPCount.get(user).put(ip, userIPCount.get(user).get(ip) + 1);
            }
        }
        userIPCount.entrySet().stream().forEach(entry -> {
            String user = entry.getKey();
            LinkedHashMap<String, Integer> iPCount = entry.getValue();
            System.out.printf("%s:%n", user);
            int counter = 1;
            for (String s : iPCount.keySet()) {
                if (counter == iPCount.size()) {
                    System.out.printf("%s => %d.%n", s, iPCount.get(s));
                    counter++;
                } else {
                    System.out.printf("%s => %d, ", s, iPCount.get(s));
                    counter++;
                }
            }
        });
    }
}
