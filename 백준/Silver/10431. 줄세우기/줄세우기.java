import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static StringTokenizer stz;
    public static int[] height = new int[20];
    public static StringBuilder sb = new StringBuilder();

    public static void addHeight() {
        for(int i = 0; i < height.length; i++) {
            height[i] = Integer.valueOf(stz.nextToken());
        }
    }

    public static int backWalk() {
        int backWalkCnt = 0;

        for(int i = 0; i < height.length - 1; i++) {
            int me = height[i];
            for(int j = i+1; j < height.length; j++) {
                int other = height[j];

                if(me > other) backWalkCnt++;
            }
        }

        return backWalkCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            stz = new StringTokenizer(br.readLine());
            stz.nextToken();
            addHeight();
            int ans = backWalk();
            sb.append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}