import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long gcd(long a, long b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

       StringTokenizer stz = new StringTokenizer(br.readLine());

       long A = Integer.parseInt(stz.nextToken());
       long B = Integer.parseInt(stz.nextToken());

       long gcd = gcd(A, B);

       sb.append(Math.abs(A * B) / gcd).append("\n");


        System.out.print(sb);

    }
}