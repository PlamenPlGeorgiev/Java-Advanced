import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;

public class _01_ReverseString {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferReader =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        str.append(bufferReader.readLine());
        System.out.println(str.reverse());
    }
}