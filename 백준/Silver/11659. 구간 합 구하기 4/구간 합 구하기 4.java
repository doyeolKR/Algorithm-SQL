import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(stz.nextToken()); // 수의 개수
        int M = Integer.valueOf(stz.nextToken()); // 구간 개수

        int[] S = new int[N+1];

        stz = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++) {
            S[i] = S[i-1] + Integer.valueOf(stz.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(stz.nextToken());
            int b = Integer.valueOf(stz.nextToken());
            sb.append(S[b] - S[a-1]).append("\n");
        }

        System.out.print(sb);
    }
}