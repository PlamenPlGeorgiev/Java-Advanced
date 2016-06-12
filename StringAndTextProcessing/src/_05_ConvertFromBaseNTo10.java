import org.apache.commons.lang.ArrayUtils;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by admin on 5.6.2016 г..
 */
public class _05_ConvertFromBaseNTo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        BigInteger base = new BigInteger(tokens[0]);
        char[] number = tokens[1].toCharArray();
        System.out.println(FromNTo10Base(number, base));
    }

    static BigInteger FromNTo10Base(char[] number, BigInteger base) {
        ArrayUtils.reverse(number);
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < number.length; i++) {
            BigInteger num = BigInteger.valueOf(Long.parseLong(Character.toString(number[i])));
            sum = sum.add(num.multiply(base.pow(i)));
        }
        return sum;
    }
}
