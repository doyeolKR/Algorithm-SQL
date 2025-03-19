import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for(int row = 0; row < 5; row++) {
            String line = br.readLine();
            for(int col = 0; col < 15; col++) {
                if(col < line.length()) {
                    arr[row][col] = line.charAt(col);
                } else {
                    arr[row][col] = ' ';
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int col = 0; col < 15; col++) {
            for(int row = 0; row < 5; row++) {
                if(arr[row][col] != ' ') {
                    sb.append(arr[row][col]);
                }
            }
        }

        System.out.println(sb);

    }
}
