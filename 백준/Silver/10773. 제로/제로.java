import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.valueOf(br.readLine());

        for(int i = 0; i < K; i++) {
            int num = Integer.valueOf(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        int ans = 0;
        for(int num : stack) {
            ans += num;
        }
        System.out.println(ans);
    }
}