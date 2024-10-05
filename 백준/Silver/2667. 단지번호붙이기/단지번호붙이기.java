import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, cnt, apart;
    static int[][] map;
    static List<Integer> ans = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void bfs(int row, int col) {
        map[row][col] = 0;
        q.add(new int[]{row, col});
        apart = 0;

        while(!q.isEmpty()) {
            apart++;
            int[] point = q.poll();
            int currentRow = point[0];
            int currentCol = point[1];

            for(int i = 0; i <4; i++) {
                int nextRow = currentRow + dy[i];
                int nextCol = currentCol + dx[i];
                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                    if(map[nextRow][nextCol] == 1) {
                        map[nextRow][nextCol] = 0;
                        q.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        ans.add(apart);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(ans);

        sb.append(cnt).append("\n");

        for(int num : ans) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);

    }
}

