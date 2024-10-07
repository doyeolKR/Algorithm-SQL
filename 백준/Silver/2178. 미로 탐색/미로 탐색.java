import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    public static void bfs(int row, int col) {
        visited[row][col] = true;
        queue.add(new int[]{row, col});

        while(!queue.isEmpty()) {
            int[] currentPoint = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextRow = currentPoint[0] + dy[i];
                int nextCol = currentPoint[1] + dx[i];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        map[nextRow][nextCol] = map[currentPoint[0]][currentPoint[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs(0, 0);

        System.out.print(map[N - 1][M - 1]);

    }
}


