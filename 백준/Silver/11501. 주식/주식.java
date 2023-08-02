import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < testCase; tc++) {
            int days = Integer.parseInt(br.readLine());
            int[] price = new int[days];
            int max = 0;
            long ans = 0;
            stz = new StringTokenizer(br.readLine());
            for (int i = 0; i < days; i++) {
                price[i]=Integer.parseInt(stz.nextToken());
            }

            for(int i = days - 1; i >= 0; i--) {
                if(price[i] > max) {
                    max = price[i];
                } else {
                    ans += max - price[i];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}