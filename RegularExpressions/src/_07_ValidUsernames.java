import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer max = Integer.MIN_VALUE;
        Pattern pattern = Pattern.compile("(\\b[a-zA-Z]\\w{2,24}\\b)");
        List<String> names = new ArrayList<>();
        Queue<String> output = new ArrayDeque<>();
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            names.add(matcher.group(1));
        }
        if (names.size() <= 2) {
            names.forEach(System.out::println);
        } else {
            for (int i = 0; i < names.size() - 1; i++) {
                int buff = names.get(i).length() + names.get(i + 1).length();
                if (buff > max) {
                    max=buff;
                    if (output.size() == 2) {
                        output.poll();
                        output.poll();
                    }
                    output.add(names.get(i));
                    output.add(names.get(i + 1));
                }
            }
            System.out.printf("%s%n",output.poll());
            System.out.printf("%s%n",output.poll());
        }
    }
}
