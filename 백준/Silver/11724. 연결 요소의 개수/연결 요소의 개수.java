import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static boolean[] visited;
    public static ArrayList<Integer>[] edgeList;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.valueOf(stz.nextToken()); // 노드의 개수
        M = Integer.valueOf(stz.nextToken()); // 에지의 개수

        visited = new boolean[N + 1];
        edgeList = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }


        for(int i = 1; i <= M; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(stz.nextToken()); // 연결 노드 1
            int v = Integer.valueOf(stz.nextToken()); // 연결 노드 2

            edgeList[u].add(v);
            edgeList[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            }
        }

        System.out.println(ans);

    }

    public static void dfs(int node) {
        visited[node] = true;

        for(int next : edgeList[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}