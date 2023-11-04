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

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int sum = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N-1;
        int ans = 0;

        Arrays.sort(arr);

        while(true) {
            if(start >= end) break;
            if(arr[start] + arr[end] == sum) {
                ans++;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] > sum) end--;
            else start++;
        }

        System.out.println(ans);

    }
}
