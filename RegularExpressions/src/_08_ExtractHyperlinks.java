import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        String regex = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (true) {
            if (line.equals("END")) {
                break;
            }
            builder.append(line);
            line = reader.readLine();
        }
        String text = builder.toString();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1));
            }
            if (matcher.group(2) != null) {
                System.out.println(matcher.group(2));
            }
            if (matcher.group(3) != null) {
                System.out.println(matcher.group(3));
            }
        }
    }
}
