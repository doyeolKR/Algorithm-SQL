import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int K = Integer.parseInt(stz.nextToken());

        int[] arr = new int[N + 1];
        int[] sum = new int[N - K + 1];
        stz = new StringTokenizer(br.readLine());

        int index = 0;

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());

            if(i <= K ) sum[index] += arr[i];
            else sum[++index] = sum[index - 1] + arr[i] - arr[i - K];
        }

        int ans = Integer.MIN_VALUE;

        for(int num : sum) {
            ans = Math.max(ans, num);
        }
        
        System.out.print(ans);

    }
}

