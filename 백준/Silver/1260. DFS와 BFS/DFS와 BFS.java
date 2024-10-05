import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, ans;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<Integer>();
    static List<List<Integer>> edgeList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void bfs(int node) {
        visited = new boolean[N];
        visited[node] = true;
        q.add(node);

        while(!q.isEmpty()){
            int currentNode = q.poll();
            sb.append(currentNode + 1).append(" ");

            for(int nextNode : edgeList.get(currentNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node + 1).append(" ");

        List<Integer> list = edgeList.get(node);
        for(int nextNode : list) {
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());

        for(int i = 0; i < N; i++) {
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;

            edgeList.get(a).add(b);
            edgeList.get(b).add(a);
        }

        for(List<Integer> edge : edgeList) {
            Collections.sort(edge);
        }

        visited = new boolean[N];

        dfs(R - 1);
        sb.append("\n");
        bfs(R - 1);

        System.out.print(sb);

    }
}
