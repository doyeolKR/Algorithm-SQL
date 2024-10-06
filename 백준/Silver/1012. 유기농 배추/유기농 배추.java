import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int width, height, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];

            if(nextRow >= 0 && nextRow < height && nextCol >= 0 && nextCol < width) {
                if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    dfs(nextRow, nextCol);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T; tc++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());

            width = Integer.parseInt(stz.nextToken());
            height = Integer.parseInt(stz.nextToken());
            int pointCnt = Integer.parseInt(stz.nextToken());

            map = new int[height][width];
            visited = new boolean[height][width];

            for(int i = 0; i < pointCnt; i++) {
                stz = new StringTokenizer(br.readLine());

                int col = Integer.parseInt(stz.nextToken());
                int row = Integer.parseInt(stz.nextToken());

                map[row][col] = 1;
            }

            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
            ans = 0;
        }

        System.out.print(sb);

    }
}

