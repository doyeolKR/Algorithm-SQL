import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int[] sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], rank++);
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.print(sb);

    }
}