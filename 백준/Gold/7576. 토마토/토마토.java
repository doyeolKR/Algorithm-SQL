import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] last;

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < 4; i++) {
                int[] next = {current[0] + dy[i], current[1] + dx[i], current[2] + 1};

                if(next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < M) {
                    if(!visited[next[0]][next[1]] && tomato[next[0]][next[1]] == 0) {
                        q.add(new int[]{next[0], next[1], next[2]});
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
            last = current;
        }
    }

    public static boolean isPerfect() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && tomato[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stz.nextToken());
        N = Integer.parseInt(stz.nextToken());

        tomato = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(stz.nextToken());
                if(tomato[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        if(isPerfect())
            System.out.print(last[2]);
        else
            System.out.print(-1);

    }
}

