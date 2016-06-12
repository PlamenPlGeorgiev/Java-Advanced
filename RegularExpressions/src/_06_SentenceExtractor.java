import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 10.6.2016 г..
 */
public class _06_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String key = bufferedReader.readLine();
        String text = bufferedReader.readLine();
        Pattern pattern = Pattern.compile("[^!?.]+[!?.]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group(0).contains(" " + key + " ")) {
                System.out.println(matcher.group(0));
            }
        }
    }
}
