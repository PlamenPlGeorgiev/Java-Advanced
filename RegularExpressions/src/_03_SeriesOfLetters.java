import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 7.6.2016 г..
 */
public class _03_SeriesOfLetters {
    public static void main(String[] args) throws IOException{
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String seq = reader.readLine();
        Pattern pattern = Pattern.compile("([a-z]|[A-Z])\\1*");
        Matcher matcher = pattern.matcher(seq);
        while (matcher.find()) {
            System.out.print(matcher.group(1));
        }
    }
}

