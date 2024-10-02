import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stz = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(stz.nextToken());
        int B = Integer.parseInt(stz.nextToken());

        stz = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(stz.nextToken());
        int D = Integer.parseInt(stz.nextToken());

        int child = (A * D) + (B * C);
        int parent = B * D;

       int gcd = gcd(child, parent);

       sb.append(child / gcd).append(" ").append(parent / gcd);

        System.out.print(sb);

    }
}