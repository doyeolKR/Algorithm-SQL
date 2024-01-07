import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        int[] A = new int[N+1];
        stz = new StringTokenizer(br.readLine());

        for(int i = 1; i <=N; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }
        Arrays.sort(A);

        int start_index = 1, end_index = N, ans = 0;

        while(start_index < end_index) {
            int sum = A[start_index] + A[end_index];

            if(sum == M) {
                ans++;
                end_index--;
            }
            else if(sum > M) {
                end_index--;
            }
            else if(sum < M) {
                start_index++;
            }
        }

        System.out.print(ans);
    }
}