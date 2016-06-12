import java.util.Scanner;

/**
 * Created by admin on 4.6.2016 г..
 */
public class _03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split("\\s+");
        int a = Integer.parseInt(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        double c = Double.parseDouble(tokens[2]);
        System.out.printf("|%s|%s|%10.2f|%-10.3f|%n",
                String.format("%-10s", HexaDecimal(a)),
                String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0'),
                b, c);
    }

    static String HexaDecimal(int a) {
        if (a == 0) {
            return "0";
        } else {
            StringBuilder num = new StringBuilder();
            String[] tokens = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            while (a > 0) {
                num.append(tokens[a % 16]);
                a /= 16;
            }
            return num.reverse().toString();
        }
    }
}
