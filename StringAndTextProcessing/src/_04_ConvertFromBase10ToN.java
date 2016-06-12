import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _04_ConvertFromBase10ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Long base = Long.parseLong(tokens[0]);
        BigInteger number = new BigInteger(tokens[1]);
        System.out.println(From10ToNBase(number, base));
    }

    static String From10ToNBase(BigInteger number, Long base) {
        if (number.equals(BigInteger.ZERO)) {
            return "0";
        } else {
            StringBuilder num = new StringBuilder();
            while (number.compareTo(BigInteger.ZERO) == 1) {
                BigInteger[] bigTokens = number.divideAndRemainder(BigInteger.valueOf(base));
                BigInteger divide = bigTokens[0];
                BigInteger remainder = bigTokens[1];
                num.append(remainder);
                number = divide;
            }
            return num.reverse().toString();
        }
    }
}