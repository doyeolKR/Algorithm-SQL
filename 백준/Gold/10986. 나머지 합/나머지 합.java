import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        long ans = 0;
        int N = Integer.valueOf(stz.nextToken());
        int M = Integer.valueOf(stz.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];

        stz = new StringTokenizer(br.readLine());

        S[0] = Integer.valueOf(stz.nextToken());

        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + Integer.valueOf(stz.nextToken());
        }

        for(int i = 0; i < N; i++) {
            int num = (int)(S[i] % M);

            if(num == 0) ans++;

            C[num]++;
        }

        for(int i = 0; i < M; i++) {
            if(C[i] > 1) {
                ans += (C[i] * (C[i]-1) / 2);
            }
        }

        System.out.println(ans);
    }
}