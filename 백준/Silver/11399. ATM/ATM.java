import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int N = Integer.valueOf(br.readLine());
        int[] A = new int[N];

        stz = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }

        for(int i = 1; i < N; i++) {
            int index = i;
            int value = A[i];

            for(int j = 0; j < i; j++) {
                if(A[j] > A[i]) {
                    index = j;
                    break;
                }
            }
            for(int j = i; j > index; j--) {
                A[j] = A[j-1];
            }
            A[index] = value;
        }

        int[] S = new int[N];
        S[0] = A[0];
        for(int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        int ans = 0;
        for(int minute : S) {
            ans += minute;
        }

        System.out.print(ans);

    } // main
}