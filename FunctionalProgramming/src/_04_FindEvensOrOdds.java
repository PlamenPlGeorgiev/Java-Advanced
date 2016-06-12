import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11.6.2016 г..
 */
public class _04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        List<Long> listOdd = new ArrayList<>();
        List<Long> listEven = new ArrayList<>();
        int start = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);
        String command = reader.readLine();
        for (int i = start; i <= end; i++) {
            if (command.equals("odd")) {
                if (i % 2 == 1) {
                    System.out.print(i + " ");
                }
            }
            if (command.equals("even")) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
