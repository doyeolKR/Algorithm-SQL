import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void cut(String str) {
        if(str.length() == 1) {
            sb.append(str);
            return;
        }

        int one = (int)(str.length() / 3);
        int two = (int)(str.length() / 3) * 2;

        cut(str.substring(0,one));
        int blank = str.substring(one,two).length();
        sb.append(" ".repeat(blank));
        cut(str.substring(two, str.length()));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);

            int num = (int) Math.pow(3, n);
            String str = "-".repeat(num);
            cut(str);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
