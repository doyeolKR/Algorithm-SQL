import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<Integer> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();

    private static void all() {
        for(int i = 0; i < 20; i++) {
            set.add(i + 1);
        }
    }

    private static void empty() {
        for(int i = 0; i < 20; i++) {
            set.remove(i + 1);
        }
    }

    private static void check(int num) {
        int val = set.contains(num) ? 1 : 0;
        sb.append(val).append("\n");
    }

    private static void toggle(int num) {
        if(set.contains(num)) set.remove(num);
        else set.add(num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            String str  = stz.nextToken();
            int num = 0;
            if(!(str.equals("all") || str.equals("empty")))
                num = Integer.parseInt(stz.nextToken());

            if(str.equals("add")) set.add(num);
            else if(str.equals("remove")) set.remove(num);
            else if(str.equals("check")) check(num);
            else if(str.equals("toggle")) toggle(num);
            else if(str.equals("all")) all();
            else if(str.equals("empty")) empty();
        }
        System.out.println(sb);
    }
}
