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
    public static String status;

    public static void makeScores() throws IOException {
        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < scoreCnt; i++) {
            scores[i] = Integer.valueOf(stz.nextToken());
        }
    }

    public static boolean inRankPossible() {
        if(scoreCnt < rankSize) {
            status = "spaceRank";
            return true;
        }

        for(int i = 0; i < scoreCnt; i++) {
            if(scores[i] < taesooScore) {
                status = "fullRank";
                return true;
            }
        }

        return false;
    }

    public static boolean insertScore() {
        for(int i = 0; i < scoreList.size(); i++) {
            if(scoreList.get(i) < taesooScore) {
                scoreList.add(i, taesooScore);
                return true;
            }
        }
        return false;
    }

    public static boolean isRenewRank() {
        if(status.equals("spaceRank")) {
            if(!insertScore()) {
                scoreList.add(taesooScore);
            }
            return true;
        }

        if(status.equals("fullRank")) {
            if(!insertScore())
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stz = new StringTokenizer(br.readLine());

        scoreCnt = Integer.valueOf(stz.nextToken());
        scores = new int[scoreCnt];
        taesooScore = Integer.valueOf(stz.nextToken());
        rankSize = Integer.valueOf(stz.nextToken());

        if(scoreCnt != 0)
            makeScores();
        else {
            System.out.println(1);
            return;
        }

        scoreList = Arrays.stream(scores)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        if(!inRankPossible()) {
            System.out.println(-1);
            return;
        }

        if(!isRenewRank()) {
            System.out.println(-1);
            return;
        }

        int rank = 1;

        for(int i = 1; i < scoreList.size(); i++) {
            if(scoreList.get(i - 1) != scoreList.get(i) && scoreList.get(i) == taesooScore) {
                rank = i + 1;
                break;
            }
        }

        System.out.println(rank);

    }
}
