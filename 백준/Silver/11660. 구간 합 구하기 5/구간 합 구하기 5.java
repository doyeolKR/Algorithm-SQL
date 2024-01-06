import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(stz.nextToken());
        int M = Integer.valueOf(stz.nextToken()); // 질의의 개수

        int[][] A = new int[N+1][N+1];
        int[][] D = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                A[i][j] = Integer.valueOf(stz.nextToken());
            }
        }

        // 2차원 배열의 구간 합 D[][] 초기화
        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(stz.nextToken());
            int y1 = Integer.valueOf(stz.nextToken());
            int x2 = Integer.valueOf(stz.nextToken());
            int y2 = Integer.valueOf(stz.nextToken());

            int ans = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}