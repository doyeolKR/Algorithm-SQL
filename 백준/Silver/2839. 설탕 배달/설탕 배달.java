import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int oCnt = N/5;

        while(oCnt > 0) {

            if((N - (5 * oCnt)) % 3 == 0) {
                break;
            }
            oCnt--;

        }

        N -= 5*oCnt;

        int ans = 0;

        if(N % 3 == 0) {
            ans = oCnt + N/3;
        } else {
            ans = -1;
        }

        System.out.println(ans);

    }
}