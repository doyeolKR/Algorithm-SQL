import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int width, height, cabbageCount;
    static int [][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int row = currentPosition[0];
            int col = currentPosition[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];

                if(nextRow >= 0 && nextRow < height && nextCol >= 0 && nextCol < width) {
                    if(map[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        map[nextRow][nextCol] = 0;
                    }
                }
            }
        }
    }

    public static int findRequiredWormsCount() {
        int ans = 0;

        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                if(map[row][col] == 1) {
                    map[row][col] = 0;
                    queue.add(new int[]{row, col});
                    bfs();
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void setCabbagePosition() throws IOException {
        for(int i = 0; i < cabbageCount; i++) {
            String[] position = br.readLine().split(" ");
            int col = Integer.parseInt(position[0]);
            int row = Integer.parseInt(position[1]);

            map[row][col] = 1;
        }
    }

    public static void runTestCase() throws IOException {
        String[] info = br.readLine().split(" ");

        width = Integer.parseInt(info[0]);
        height = Integer.parseInt(info[1]);
        cabbageCount = Integer.parseInt(info[2]);

        map = new int[height][width];

        setCabbagePosition();

        int ans = findRequiredWormsCount();
        sb.append(ans).append("\n");
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            runTestCase();
        }
        System.out.println(sb);
    }
}
