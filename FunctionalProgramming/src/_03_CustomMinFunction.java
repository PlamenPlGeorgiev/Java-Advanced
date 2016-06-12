import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11.6.2016 г..
 */
public class _03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = reader.readLine().split("\\s+");
        List<Integer> set = new ArrayList<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num));
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : set) {
            if (min > integer) {
                min = integer;
            }
        }
        System.out.println(min);
    }
}
