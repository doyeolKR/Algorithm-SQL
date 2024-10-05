import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, cnt;
    static int[] ans;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int root) {
        visited[root] = true;
        ans[root] = ++cnt;

        List<Integer> list = graph.get(root);
        for (int num : list) {
            if(!visited[num]) {
                dfs(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());

        ans = new int[N];
        visited = new boolean[N];

        for(int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(List<Integer> list : graph) {
            Collections.sort(list, Collections.reverseOrder());
        }

        dfs(R-1);

        for(int num : ans) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);

    }
}









