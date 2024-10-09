import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());

            if(i == 0) sum[i] = arr[i];
            else sum[i] = sum[i-1] + arr[i];
        }

        for(int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stz.nextToken()) - 1;
            int end = Integer.parseInt(stz.nextToken()) - 1;

            int ans = 0;
            if(start == 0) ans = sum[end];
            else ans = sum[end] - sum[start - 1];

            sb.append(ans).append("\n");
        }

        System.out.print(sb);

    }
}

