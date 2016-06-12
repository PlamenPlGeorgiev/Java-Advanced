import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2.6.2016 г..
 */
public class _13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> venueSingerMoney = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("End")) {
            Pattern pattern = Pattern.compile("(.*) @([\\w*\\s*]+) (\\d+) (\\d+)");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String venue = matcher.group(2);
                String singer = matcher.group(1);
                int price = Integer.parseInt(matcher.group(3));
                int tickets = Integer.parseInt(matcher.group(4));
                int money = price * tickets;
                if (!venueSingerMoney.containsKey(venue)) {
                    venueSingerMoney.put(venue, new LinkedHashMap<>());
                }
                if (!venueSingerMoney.get(venue).containsKey(singer)) {
                    venueSingerMoney.get(venue).put(singer, 0);
                }
                venueSingerMoney.get(venue).put(singer, venueSingerMoney.get(venue).get(singer) + money);
            }
            input = sc.nextLine();
        }
        for (String s : venueSingerMoney.keySet()) {
            System.out.println(s);
            venueSingerMoney.get(s).entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .forEach(singerMoney -> {
                        String singer = singerMoney.getKey();
                        Integer money = singerMoney.getValue();
                        System.out.printf("#  %s -> %d%n", singer, money);
                    });
        }
    }
}
