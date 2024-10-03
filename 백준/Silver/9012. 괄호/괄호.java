import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String solve(String s) {
        Stack<String> stack = new Stack<>();
        String[] str = s.split("");

        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("(")) {
                stack.push(str[i]);
            } else {
                if(stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < N; tc++) {
            sb.append(solve(br.readLine())).append("\n");
        }

        System.out.print(sb);

    }
}