import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void sum(int y1, int x1, int y2, int x2) {
        int sum = 0;
        for(int y = y1; y <= y2; y++) {
            for(int x = x1; x <= x2; x++) {
                sum += arr[y][x];
            }
        }
        sb.append(sum).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            stz = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(stz.nextToken()) - 1;
            int x1 = Integer.parseInt(stz.nextToken()) - 1;
            int y2 = Integer.parseInt(stz.nextToken()) - 1;
            int x2 = Integer.parseInt(stz.nextToken()) - 1;
            sum(y1, x1, y2, x2);
        }
        System.out.println(sb);
    }
}
