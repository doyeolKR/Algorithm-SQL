import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;

        int N = Integer.valueOf(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int index = stack.pop();
                ans[index] = A[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = -1;
        }
        for(int i = 0 ; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);

    } // main
}