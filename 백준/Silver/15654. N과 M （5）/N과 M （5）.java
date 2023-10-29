import java.io.*;
import java.util.*;


public class Main {

    public static int N, M;
    public static int[] arr, ans;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int m) throws IOException {
        if(m == M) {
            for(int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[m] = arr[i];
                dfs(m+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];


        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb.toString());

    }
}
