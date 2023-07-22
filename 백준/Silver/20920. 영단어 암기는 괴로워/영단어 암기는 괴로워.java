import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    if(o1.length() == o2.length())
                        return o1.compareTo(o2);
                    else return o2.length() - o1.length();
                }
                return map.get(o2) - map.get(o1);
            }
        });
        for(String key : list) {
            sb.append(key).append("\n");
        }
        System.out.println(sb);
    }
}
