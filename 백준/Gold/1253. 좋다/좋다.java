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
        int[] A = new int[N];

        // 배열 A 초기화 하고 정렬
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }
        Arrays.sort(A);

        int ans = 0;

        for(int good = 0; good < N; good++) {
            int start_index = 0;
            int end_index = N-1;

            while(start_index < end_index) {
                if(start_index == good || end_index == good) {
                    if(start_index == good) start_index++;
                    else if(end_index == good) end_index--;
                }
                else {
                    long sum = A[start_index] + A[end_index];

                    if(sum == A[good]) {
                        ans++;
                        break;
                    }
                    else if(sum > A[good]) {
                        end_index--;
                    }
                    else if(sum < A[good]) {
                        start_index++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}