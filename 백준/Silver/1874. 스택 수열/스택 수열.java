import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean isNo = false;
        int num = 1;

        for(int i = 0; i < N; i++) {
            int currentA = Integer.valueOf(br.readLine());

            if(currentA >= num) {
                while(currentA >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }
            else {
                int popA = stack.pop();
                if(currentA < popA) {
                    isNo = true;
                    break;
                }
                else sb.append("-").append("\n");
            }
        }

        if(isNo) System.out.println("NO");
        else System.out.println(sb);

    } // main
}