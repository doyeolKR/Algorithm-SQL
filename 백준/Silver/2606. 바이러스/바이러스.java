import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static boolean[] visited;
    static List<List<Integer>> edgeList = new ArrayList<>();

    public static void dfs(int node) {
        visited[node] = true;

        List<Integer> list = edgeList.get(node);
        for(int num : list) {
            if(!visited[num]) {
                ans++;
                dfs(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            edgeList.get(a).add(b);
            edgeList.get(b).add(a);
        }

        dfs(0);

        System.out.print(ans);

    }
}

