import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static Set<Integer> set = new HashSet<>();

    public static void all() {
        for(int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    public static void empty() {
        for(int i = 1; i <= 20; i++) {
            set.remove(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cnt; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());

            String command = stz.nextToken();

            if(command.equals("add")) {
                int num = Integer.valueOf(stz.nextToken());
                set.add(num);
            } else if(command.equals("remove")) {
                int num = Integer.valueOf(stz.nextToken());
                set.remove(num);
            } else if(command.equals("check")) {
                int num = Integer.valueOf(stz.nextToken());
                if(set.contains(num))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            } else if(command.equals("toggle")) {
                int num = Integer.valueOf(stz.nextToken());
                if(set.contains(num))
                    set.remove(num);
                else
                    set.add(num);
            } else if(command.equals("all")) {
                all();
            } else if(command.equals("empty")) {
                empty();
            }
        }
        System.out.println(sb);
    }
}
