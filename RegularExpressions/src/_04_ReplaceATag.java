import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 10.6.2016 г..
 */
public class _04_ReplaceATag {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (!line.equals("end")) {
            builder.append(line);
            line = reader.readLine();
        }
        String result = builder.toString().replaceAll("<a","[URL");
        result = result.replaceAll("</a>","[/URL]");
        System.out.println(result);
    }
}
