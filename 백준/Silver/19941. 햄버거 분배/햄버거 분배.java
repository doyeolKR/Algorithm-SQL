import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static StringTokenizer stz;
    public static int deskLength, selectLength;
    public static char[] hpLocation;
    public static boolean[] check;

    public static void possibleEatHamburger() {
        for(int i = 0; i < hpLocation.length; i++) {
            if(hpLocation[i] == 'P') {
                boolean foundHamburger = false;

                for(int j = selectLength; j >= 1; j--) {
                    if(i - j >= 0 && hpLocation[i - j] == 'H' && !check[i - j]) {
                        check[i - j] = true;
                        foundHamburger = true;
                        break;
                    }
                }
                if(!foundHamburger) {
                    for(int j = 1; j <= selectLength; j++) {
                        if(i + j < hpLocation.length && hpLocation[i + j] == 'H' && !check[i + j]) {
                            check[i + j] = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static int maxPerson() {
        int personCanEatHamburger = 0;

        for(boolean isEat : check) {
            if(isEat) personCanEatHamburger++;
        }
        return personCanEatHamburger;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stz = new StringTokenizer(br.readLine());

        deskLength = Integer.valueOf(stz.nextToken());
        selectLength = Integer.valueOf(stz.nextToken());
        hpLocation = br.readLine().toCharArray();
        check = new boolean[hpLocation.length];

        possibleEatHamburger();
        System.out.println(maxPerson());
    }
}
