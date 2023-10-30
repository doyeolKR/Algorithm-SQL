import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());

            String name = stz.nextToken();
            String status = stz.nextToken();

            if(map.containsKey(name)) map.remove(name);
            else map.put(name, status);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, Comparator.reverseOrder());

        list.forEach(name -> System.out.println(name));

    }
}
