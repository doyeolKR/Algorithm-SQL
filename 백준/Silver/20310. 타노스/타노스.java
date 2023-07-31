import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int zero = 0;
        int one = 0;

        for(char c : str.toCharArray()) {
            if(c == '0') zero++;
            if(c == '1') one++;
        }
        zero /= 2;
        one /= 2;
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(zero)).append("1".repeat(one));
        System.out.println(sb);
    }
}
