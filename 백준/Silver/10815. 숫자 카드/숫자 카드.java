import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(stz.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(stz.nextToken()))) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }
}