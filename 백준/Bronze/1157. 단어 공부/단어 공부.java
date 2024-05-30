import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.toUpperCase();

        int[] array = new int[26];

        char[] alphabet = str.toCharArray();

        for(char letter : alphabet) {
            array[letter - 'A']++;
        }

        int max = 0;
        int index = 0;
        int maxCnt = 0;

        for(int cnt : array) {
            if(cnt > max) max = cnt;
        }

        for(int i = 0; i < array.length; i++) {
            if(max == array[i]) {
                index = i;
                maxCnt++;
            }
            if(maxCnt >= 2) {
                System.out.println("?");
                return;
            }
        }
        char letter = (char)(index + 'A');
        System.out.println(letter);
    }
}
