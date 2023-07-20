import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static boolean[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    private static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for(int i = 1; i <= N; i++) {
                if(arr[start][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for(int i = 0; i <= N; i++) {
            if(!visited[i] && arr[start][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        V = Integer.parseInt(stz.nextToken());

        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());

            arr[a][b] = arr[b][a] = true;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }
}
