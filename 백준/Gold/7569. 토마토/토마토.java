import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int width, height, floor;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0 ,0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    static boolean setBox() throws IOException {
        boolean isAllTomatoOk = true;

        for(int depth = 0; depth < floor; depth++) {
            for(int row = 0; row < height; row++) {
                String[] input = br.readLine().split(" ");
                for(int col = 0; col < width; col++) {
                    box[depth][row][col] = Integer.parseInt(input[col]);
                    if(box[depth][row][col] == 0) {
                        isAllTomatoOk = false;
                    } else if(box[depth][row][col] == 1) {
                        queue.add(new int[]{depth, row, col});
                        visited[depth][row][col] = true;
                    }
                }
            }
        }
        return isAllTomatoOk;
    }

    static boolean validatePoint(int nd, int nr, int nc) {
        return nd >= 0 && nd < floor && nr >= 0 && nr < height && nc >= 0 && nc < width;
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            int depth = currentPoint[0];
            int row = currentPoint[1];
            int col = currentPoint[2];

            for(int i = 0; i < 6; i++) {
                int nd = depth + dz[i];
                int nr = row + dy[i];
                int nc = col + dx[i];

                if(validatePoint(nd, nr, nc) && !visited[nd][nr][nc] && box[nd][nr][nc] == 0) {
                    queue.add(new int[]{nd, nr, nc});
                    box[nd][nr][nc] = box[depth][row][col] + 1;
                    visited[nd][nr][nc] = true;
                }
            }
        }
    }

    static int checkBox() {
        int lastDay = 0;

        for(int depth = 0; depth < floor; depth++) {
            for(int row = 0; row < height; row++) {
                for(int col = 0; col < width; col++) {
                    if(box[depth][row][col] == 0) {
                        return -1;
                    }
                    if(box[depth][row][col] > lastDay) {
                        lastDay = box[depth][row][col];
                    }
                }
            }
        }
        return lastDay - 1;
    }

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        width = Integer.parseInt(input[0]);
        height = Integer.parseInt(input[1]);
        floor = Integer.parseInt(input[2]);

        box = new int[floor][height][width];
        visited = new boolean[floor][height][width];

        boolean isAllTomatoOk = setBox();
        if (isAllTomatoOk) {
            System.out.println(0);
            System.exit(0);
        }

        bfs();

        System.out.println(checkBox());
    }
}
