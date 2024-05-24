import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int wordCnt;
    public static int standardLength;
    public static BufferedReader br;
    public static StringTokenizer stz;
    public static HashMap<String, Integer> map =  new HashMap<>();

    static class WordInfo implements Comparable<WordInfo>{
        public String word;
        public int cnt;

        public WordInfo(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(WordInfo o) {
            if(o.cnt != this.cnt)
                return o.cnt - this.cnt;
            if(o.word.length() != this.word.length())
                return o.word.length() - this.word.length();

            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stz = new StringTokenizer(br.readLine());

        wordCnt = Integer.valueOf(stz.nextToken());
        standardLength = Integer.valueOf(stz.nextToken());

        for(int i = 0; i < wordCnt; i++) {
            String word = br.readLine();

            if(map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                if(word.length() >= standardLength) map.put(word, 1);
        }

        List<WordInfo> list = new ArrayList<>();

        for(Map.Entry<String, Integer> map : map.entrySet()) {
            String word = map.getKey();
            int cnt = map.getValue();

            list.add(new WordInfo(word, cnt));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(WordInfo info : list) {
            sb.append(info.word).append("\n");
        }

        System.out.println(sb);
    }
}
