import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

public class _02_StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length() == 20) {
            System.out.println(str);
        } else if (str.length() > 20) {
            System.out.println(str.substring(0, 21));
        } else {
            String s = "*";
            String output = StringUtils.rightPad(str, 20, s);
            System.out.println(output);
        }
    }
}
