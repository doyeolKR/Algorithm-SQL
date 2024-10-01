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
            if(map.containsKey(cardNum)) {
                map.put(cardNum, map.get(cardNum) + 1);
            } else {
                map.put(cardNum, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int cardNum = Integer.parseInt(stz.nextToken());
            if(map.containsKey(cardNum)) {
                sb.append(map.get(cardNum)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);

    }
}