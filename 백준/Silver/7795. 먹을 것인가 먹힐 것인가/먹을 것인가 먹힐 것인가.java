import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            stz = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(stz.nextToken());
            int M = Integer.parseInt(stz.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            B = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(A);
            Arrays.sort(B);
            
            int ans = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[j] <= B[k]) {
                        break;
                    }
                    else {
                        ans += 1;
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
