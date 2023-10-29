import java.io.*;
import java.util.*;


public class Main {

    public static int N, M;
    public static int[] arr, ans;
    public static boolean[] visited;
    public static BufferedWriter bw;

    public static void dfs(int m) throws IOException {
        if(m == M) {
            for(int i = 0; i < M; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
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
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        bw.flush();;
        bw.close();

    }
}
