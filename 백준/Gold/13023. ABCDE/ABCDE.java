import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] relation;
    public static int N, M;
    public static boolean arrive;
    public static boolean[] visited;

    public static void DFS(int now, int depth) {
        if(depth == 5) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int friend : relation[now]) {
            if(!visited[friend]) {
                DFS(friend, depth+ + 1);
            }
        }
        visited[now] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.valueOf(stz.nextToken()); // 사람의 수
        M = Integer.valueOf(stz.nextToken()); // 관계의 수

        arrive = false;

        visited = new boolean[N];

        relation = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            relation[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(stz.nextToken());
            int E = Integer.valueOf(stz.nextToken());

            relation[S].add(E);
            relation[E].add(S);
        }

        for(int i = 0; i < N; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println(1);
        else System.out.println(0);

    }
}