import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        stz = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(stz.nextToken());
            map.put(cardNum, map.getOrDefault(cardNum, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int cardNum = Integer.parseInt(stz.nextToken());
            sb.append(map.getOrDefault(cardNum, 0)).append(" ");
        }

        System.out.print(sb);

    }
}