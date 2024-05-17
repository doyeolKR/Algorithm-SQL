import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Country implements Comparable<Country>{
        int id;
        int gold;
        int silver;
        int bronze;
        int rating;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if(this.gold != o.gold)
                return o.gold - this.gold;
            if(this.silver != o.silver)
                return o.silver - this.silver;
            if(this.bronze != o.bronze)
                return o.bronze - this.bronze;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Country{id=" + id + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + ", rating=" + rating + '}';
        }
    }

    public static BufferedReader br;
    public static StringTokenizer stz;
    public static int countryCnt;
    public static int myCountryId;
    public static int rating = 1;
    public static int duplication = 0;
    public static Country[] countries;

    public static void makeCountries() throws IOException {
        for(int i = 0; i < countryCnt; i++) {
            stz = new StringTokenizer(br.readLine());

            int id = Integer.valueOf(stz.nextToken());
            int gold = Integer.valueOf(stz.nextToken());
            int silver = Integer.valueOf(stz.nextToken());
            int bronze = Integer.valueOf(stz.nextToken());

            countries[i] = new Country(id, gold, silver, bronze);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stz = new StringTokenizer(br.readLine());

        countryCnt = Integer.valueOf(stz.nextToken());
        myCountryId = Integer.valueOf(stz.nextToken());

        countries = new Country[countryCnt];

        makeCountries();

        Arrays.sort(countries);

        countries[0].rating = rating;

        for(int i = 1; i < countries.length; i++) {
            if(
                countries[i-1].gold == countries[i].gold &&
                countries[i-1].silver == countries[i].silver &&
                countries[i-1].bronze == countries[i].bronze
            ) {
                countries[i].rating = rating;
                duplication++;
            }
            else {
                countries[i].rating = (++rating + duplication);
                duplication = 0;
            }
        }

        for(int i = 0; i < countries.length; i++) {
            if(countries[i].id == myCountryId) {
                System.out.println(countries[i].rating);
                break;
            }
        }
    }
}