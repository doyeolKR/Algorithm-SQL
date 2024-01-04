import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, seq;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.valueOf(stz.nextToken());
        M = Integer.valueOf(stz.nextToken());
        R = Integer.valueOf(stz.nextToken());

        order = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++) {
            nodeList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(stz.nextToken());
            int v = Integer.valueOf(stz.nextToken());

            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
        }

        for(int i = 0; i < N+1; i++) {
            Collections.sort(nodeList.get(i), Comparator.reverseOrder());
        }

        seq = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < order.length; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        order[node] = seq++;

        for(int i = 0; i < nodeList.get(node).size(); i++) {
            int next = nodeList.get(node).get(i);
            if(!visited[next]) {
                dfs(next);
            }
        }


    }
}