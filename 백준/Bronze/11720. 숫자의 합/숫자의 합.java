import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String str = br.readLine();

        char[] arr = str.toCharArray();

        int ans = 0;

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i] - 48;
            ans += num;
        }
        System.out.println(ans);
    }
}