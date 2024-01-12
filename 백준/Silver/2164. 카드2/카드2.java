import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            que.add(i);
        }

        while(que.size() != 1) {
            que.poll();
            Integer card = que.poll();
            que.add(card);
        }

        System.out.println(que.poll());

    } // main
}