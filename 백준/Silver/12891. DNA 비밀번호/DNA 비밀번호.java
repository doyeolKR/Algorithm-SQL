import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] checkArr = new int[4];
    static int[] myArr = new int[4];
    static int checkSecretNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int ans = 0;

        int S = Integer.valueOf(stz.nextToken()); // DNA 문자열 길이
        int P = Integer.valueOf(stz.nextToken()); // DNA 의 부분 문자열 길이

        char[] DNA = new char[S];
        DNA = br.readLine().toCharArray();

        // DNA 필수 포함 문자 개수 초기화
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.valueOf(stz.nextToken());
            if(checkArr[i] == 0) checkSecretNumber++;
        }

        for(int i = 0; i < P; i++) {
            add(DNA[i]);
        }

        if(checkSecretNumber == 4) ans++;

        for(int i = P; i < S; i++) {
            int j = i - P;
            remove(DNA[j]);
            add(DNA[i]);
            if (checkSecretNumber == 4) ans++;
        }

        System.out.print(ans);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecretNumber++;
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecretNumber++;
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecretNumber++;
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecretNumber++;
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A' :
                if(myArr[0] == checkArr[0]) checkSecretNumber--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecretNumber--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecretNumber--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecretNumber--;
                myArr[3]--;
                break;
        }
    }
}