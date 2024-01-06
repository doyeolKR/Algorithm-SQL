import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int N = Integer.valueOf(br.readLine());
        int[] score = new int[N];

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            score[i] = Integer.valueOf(stz.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < score.length; i++) {
            if(score[i] > max) max = score[i];
            sum += score[i];
        }
        double ans = sum * 100.0 / max / N;
        System.out.print(ans);
    }
}