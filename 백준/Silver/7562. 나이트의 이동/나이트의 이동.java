import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, targetRow, targetCol;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas= {
            {-2, -1}, {-2, 1}, {-1, -2}, {1, -2},
            {2, -1}, {2, 1}, {1, 2}, {-1, 2}
    };

    public static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            if(current[0] == targetRow && current[1] == targetCol) return;

            for(int i=0; i<8; i++) {
                int nextRow = current[0] + deltas[i][0];
                int nextCol = current[1] + deltas[i][1];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                    if(!visited[nextRow][nextCol]) {
                        q.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        map[nextRow][nextCol] = map[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            stz = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stz.nextToken());
            int col = Integer.parseInt(stz.nextToken());

            stz = new StringTokenizer(br.readLine());
            targetRow = Integer.parseInt(stz.nextToken());
            targetCol = Integer.parseInt(stz.nextToken());

            bfs(row, col);

            sb.append(map[targetRow][targetCol]).append("\n");
        }

        System.out.print(sb);

    }
}

