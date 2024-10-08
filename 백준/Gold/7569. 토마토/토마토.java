import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] tomato;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {-1, 1, 0, 0, 0 ,0};

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < 6; i++) {
                int[] next = {current[0] + dh[i], current[1] + dy[i], current[2] + dx[i]};

                if(next[0] < 0 || next[0] >= H || next[1] < 0 || next[1] >= N ||
                    next[2] < 0 || next[2] >= M || tomato[next[0]][next[1]][next[2]] != 0)
                    continue;

                q.add(next);
                tomato[next[0]][next[1]][next[2]] = tomato[current[0]][current[1]][current[2]] + 1;
            }
        }
    }

    public static int whatDay() {
        int day = 0;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(tomato[i][j][k] == 0)
                        return -1;
                    day = Math.max(day, tomato[i][j][k]);
                }
            }
        }
        return day - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stz.nextToken());
        N = Integer.parseInt(stz.nextToken());
        H = Integer.parseInt(stz.nextToken());

        tomato = new int[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                stz = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(stz.nextToken());

                    if(tomato[i][j][k] == 1)
                        q.offer(new int[]{i, j, k});
                }
            }
        }

        bfs();

        System.out.print(whatDay());

    }
}
