import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = new LinkedList<>();

        stz = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++) {
            list.add(Integer.valueOf(stz.nextToken()));
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(j) > list.get(i)) {
                    int value = list.remove(i);
                    list.add(j,value);
                }
            }
        }

        int[] S = new int[N + 1];
        for(int i = 1; i < N+1; i++) {
            S[i] = S[i - 1] + list.get(i - 1);
        }

        int ans = 0;
        for(int minute : S) {
            ans += minute;
        }

        System.out.print(ans);

    } // main
}