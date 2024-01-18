import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int shift = 1000000;
        int range = 2000001;

        boolean[] arr = new boolean[range];

        for(int i = 0; i < N; i++) {
            arr[Integer.valueOf(br.readLine()) + shift] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < range; i++) {
            if(arr[i]) {
                sb.append(i - shift).append("\n");
            }
        }
        System.out.print(sb);
    }
}