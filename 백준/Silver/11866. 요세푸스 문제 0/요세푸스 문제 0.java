import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int K = Integer.parseInt(stz.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.offer(i + 1);
        }

        sb.append("<");

        while(!q.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                int num = q.poll();
                q.offer(num);
            }

            sb.append(q.poll());
            if(q.isEmpty()) sb.append(">");
            else sb.append(",").append(" ");
        }

        System.out.print(sb);

    }
}

