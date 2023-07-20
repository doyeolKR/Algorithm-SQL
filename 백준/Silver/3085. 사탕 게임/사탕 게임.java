import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, max;
    private static String[][] arr;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private static void changeCandy(int offsetX, int offsetY) {
        for(int d = 0; d < 4; d++) {
            int x = offsetX + dx[d];
            int y = offsetY + dy[d];

            String tmp = arr[offsetY][offsetX];

            if(x >= 0 && y >= 0 && x < N && y < N) {
                arr[offsetY][offsetX] = arr[y][x];
                arr[y][x] = tmp;
                findMax();
                arr[y][x] = arr[offsetY][offsetX];
                arr[offsetY][offsetX] = tmp;
            }
        }
    }

    private static void changeCandy() {
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                changeCandy(x, y);
            }
        }
    }

    private static int checkLength(int offsetX, int offsetY) {
        int rowLength = 1;
        int colLength = 1;
        String c = arr[offsetY][offsetX];

        while(offsetX + 1 < N && arr[offsetY][offsetX + 1].equals(c)) {
            offsetX++;
            colLength++;
        }

        while(offsetY + 1 < N && arr[offsetY + 1][offsetX].equals(c)) {
            offsetY++;
            rowLength++;
        }
        return Math.max(rowLength, colLength);
    }

    private static void findMax() {
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                int length = checkLength(x, y);
                if(length > max) max = length;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for(int y = 0; y < N; y++) {
            String str = br.readLine();
            for(int x = 0; x < N; x++) {
                arr[y][x] = String.valueOf(str.charAt(x));
            }
        }

        findMax();
        changeCandy();
        System.out.println(max);

    }
}
