import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _07_SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger first = new BigInteger(sc.nextLine());
        BigInteger second = new BigInteger(sc.nextLine());
        first= first.add(second);
        System.out.println(first);
    }
}
