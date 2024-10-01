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

        Set<Integer> set = new HashSet<>();

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(stz.nextToken()));
        }

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            Integer num = Integer.parseInt(stz.nextToken());

            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        System.out.print(set.size());

    }
}