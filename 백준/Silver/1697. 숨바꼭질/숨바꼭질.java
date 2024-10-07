import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs(int position) {
        queue.add(position);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current == M) return;

            for(int i = 0; i < 3; i++) {
                int next = 0;
                if(i == 0) next = current - 1;
                if(i == 1) next = current + 1;
                if(i == 2) next = current * 2;

                if(next >=0 && next < 100001 && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        visited = new int[100001];

        bfs(N);

        System.out.print(visited[M]);

    }
}

