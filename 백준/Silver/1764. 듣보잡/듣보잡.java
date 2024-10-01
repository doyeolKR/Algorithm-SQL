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

        Set<String> set  = new HashSet<>();

        for(int i = 1; i <= N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= M; i++) {
            String name = br.readLine();

            if(set.contains(name)) {
                list.add(name);
            }
        }

        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for(String name : list) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);

    }
}