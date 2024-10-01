import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();

            if(map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }
        }

        int cnt = 0;

        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                cnt++;
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        sb.append(cnt).append("\n");

        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);

    }
}