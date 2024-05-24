import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countryCnt = Integer.valueOf(br.readLine());
        List<Integer> countries = new ArrayList<>();
        int totalRequest = 0;

        StringTokenizer stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < countryCnt; i++) {
            int request = Integer.valueOf(stz.nextToken());
            countries.add(request);
            totalRequest += request;
        }

        int budget = Integer.valueOf(br.readLine());

        if(totalRequest <= budget) {
            Collections.sort(countries);
            System.out.println(countries.get(countryCnt - 1));
            return;
        }

        int average = 0;

        while(true) {
            average = budget / countryCnt;
            int okCountries = 0;

            for(int i = countries.size() - 1; i >= 0 ; i--) {
                int request = countries.get(i);

                if(request <= average) {
                    budget -= request;
                    countries.remove(i);
                    countryCnt--;
                    okCountries++;
                }
            }
            if(okCountries == 0)
                break;
        }

        System.out.println(average);

    }
}
