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
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        Map<Integer, String> keyIsNum = new HashMap<>();
        Map<String, Integer> keyIsName = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pocketmon = br.readLine();
            keyIsNum.put(i, pocketmon);
            keyIsName.put(pocketmon, i);
        }


        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(keyIsName.containsKey(str)) {
                sb.append(keyIsName.get(str)).append('\n');
            } else {
                sb.append(keyIsNum.get(Integer.parseInt(str))).append('\n');
            }
        }

        System.out.print(sb);

    }
}