import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, cnt;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] edges;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        stz = new StringTokenizer(br.readLine());

        N = Integer.valueOf(stz.nextToken());
        M = Integer.valueOf(stz.nextToken());
        R = Integer.valueOf(stz.nextToken());

        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(stz.nextToken());
            int v = Integer.valueOf(stz.nextToken());

            edges[u].add(v);
            edges[v].add(u);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.print(sb);

    } // main

    static void dfs(int num) {
        ans[num] = ++cnt;
        visited[num] = true;
        for(int value : edges[num]) {
            if(!visited[value]) {
                dfs(value);
            }
        }
    }
}