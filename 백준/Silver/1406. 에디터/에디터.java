import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for(char c : br.readLine().toCharArray()) {
            left.push(String.valueOf(c));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());

            String command = stz.nextToken();

            switch(command) {
                case "L" :
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D" :
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B" :
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P" :
                    left.push(stz.nextToken());
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb.toString());
    }
}