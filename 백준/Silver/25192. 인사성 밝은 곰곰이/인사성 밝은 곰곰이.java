import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chattingCount = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        int answer = 0;


        for(int i = 0; i < chattingCount; i++) {
            String chat = br.readLine();

            if(chat.equals(ENTER)) {
                answer += set.size();
                set = new HashSet<>();
                continue;
            }

            set.add(chat);
        }

        answer += set.size();

        System.out.println(answer);

    }
}
