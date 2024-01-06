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

        int[] A = new int[N+1];
        int[] S = new int[N+1];

        stz = new StringTokenizer(br.readLine());

        // 배열 A[] 의 값 넣어주기
        for(int i = 1; i < N+1; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }

        // 합 배열 S[]의 값 넣어주기
        for(int i = 1; i < N+1; i++) {
            S[i] = S[i-1] + A[i];
        }

        StringBuilder sb = new StringBuilder();

        // 구간 합 출력하기
        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(stz.nextToken());
            int b = Integer.valueOf(stz.nextToken());
            sb.append(S[b] - S[a-1]).append("\n");
        }

        System.out.print(sb);
    }
}