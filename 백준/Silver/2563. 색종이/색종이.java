import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] map = new boolean[101][101];

    public static int calculate() {
        int count = 0;

        for(int y = 0; y < 101; y++) {
            for(int x = 0; x < 101; x++) {
                if(map[y][x]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int square = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < square; tc++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());

            for(int row = y; row < y + 10; row++) {
                for(int col = x; col < x + 10; col++) {
                    map[row][col] = true;
                }
            }
        }
        int count = calculate();
        System.out.println(count);
    }
}