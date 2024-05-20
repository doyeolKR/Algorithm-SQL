import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Person {
        int weight;
        int height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }

    public static BufferedReader br;
    public static StringTokenizer stz;
    public static int personCnt;
    public static Person[] people;

    public static void makePeople() throws IOException {
        for(int i = 0; i < personCnt; i++) {
            stz = new StringTokenizer(br.readLine());
            int weight = Integer.valueOf(stz.nextToken());
            int height = Integer.valueOf(stz.nextToken());

            people[i] = new Person(weight, height);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        personCnt = Integer.valueOf(br.readLine());
        people = new Person[personCnt];

        makePeople();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < personCnt; i++) {
            int cnt = 0;
            for(int j = 0; j < personCnt; j++) {
                if(people[j].weight > people[i].weight && people[j].height > people[i].height)
                    cnt++;
            }
            sb.append(cnt + 1).append(" ");
        }

        System.out.println(sb);

    }
}
