import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pocketmon = br.readLine();
            map1.put(i, pocketmon);
            map2.put(pocketmon, i);
        }


        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(isInteger(str)) {
                sb.append(map1.get(Integer.parseInt(str))).append('\n');
            } else {
                sb.append(map2.get(str)).append('\n');
            }
        }

        System.out.print(sb);

    }
}