import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int sum(char[] arr) {
        int sum = 0;

        for(char c : arr) {
            int num = c - '0';
            if(num >= 0 && num <= 9) sum += num;
        }
        return sum;
    }
    public static int cal(String o1, String o2) {
        int sum1 = sum(o1.toCharArray());
        int sum2 = sum(o2.toCharArray());
        return sum1 - sum2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            list.add(br.readLine());
        }

        list.sort((o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            else {
                int value = cal(o1, o2);

                if(value != 0) return value;
                else return o1.compareTo(o2);
            }
        });

        list.forEach(value -> System.out.println(value));

    }
}