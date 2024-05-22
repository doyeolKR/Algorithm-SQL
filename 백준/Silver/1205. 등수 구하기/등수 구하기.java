import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static BufferedReader br;
    public static StringTokenizer stz;
    public static int scoreCnt;
    public static int[] scores;
    public static int taesooScore;
    public static int rankSize;
    public static List<Integer> scoreList;

    public static void makeScores() throws IOException {
        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < scoreCnt; i++) {
            scores[i] = Integer.parseInt(stz.nextToken());
        }
    }

    public static boolean inRankPossible() {
        if(scoreCnt < rankSize) {
            return true;
        }
        return scores[scores.length - 1] < taesooScore;
    }

    public static void insertScore() {
        boolean inserted = false;
        for(int i = 0; i < scoreList.size(); i++) {
            if(scoreList.get(i) < taesooScore) {
                scoreList.add(i, taesooScore);
                inserted = true;
                break;
            }
        }
        if(!inserted) {
            scoreList.add(taesooScore);
        }
        if(scoreList.size() > rankSize) {
            scoreList.remove(scoreList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stz = new StringTokenizer(br.readLine());

        scoreCnt = Integer.parseInt(stz.nextToken());
        taesooScore = Integer.parseInt(stz.nextToken());
        rankSize = Integer.parseInt(stz.nextToken());

        if(scoreCnt == 0) {
            System.out.println(1);
            return;
        }

        scores = new int[scoreCnt];
        makeScores();

        scoreList = Arrays.stream(scores)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        if(!inRankPossible()) {
            System.out.println(-1);
            return;
        }

        insertScore();

        int rank = 1;
        for(int i = 0; i < scoreList.size(); i++) {
            if(scoreList.get(i) == taesooScore) {
                rank = i + 1;
                break;
            }
        }

        System.out.println(rank);
    }
}
