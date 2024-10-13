import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int findNum = Integer.parseInt(br.readLine());

        int sIndex = 0;
        int lIndex = N-1;
        int ans = 0;
        int sum = 0;

        Arrays.sort(arr);

        while(sIndex < lIndex) {
            sum = arr[sIndex] + arr[lIndex];
            if(sum > findNum) lIndex--;
            if(sum < findNum) sIndex++;
            if(sum == findNum) {
                ans++;
                sIndex++;
            }
        }

        System.out.println(ans);

    }
}

