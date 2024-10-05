import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, apart;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> ans = new ArrayList<>();
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        apart++;

        for(int i = 0; i < 4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];

            if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                if(map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    dfs(nextRow, nextCol);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    apart = 0;
                    dfs(i, j);
                    ans.add(apart);
                }
            }
        }

        Collections.sort(ans);

        sb.append(ans.size()).append("\n");

        for(int num : ans) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);

    }
}

