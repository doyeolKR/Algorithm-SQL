import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] visitorCnt;
    public static int afterStart, period;

    public static long searchMaxVisitor() {
        long maxVisitor = 0;
        long sum = 0;

        for(int i = 0; i < afterStart; i++) {
            if(i >= period) {
                sum = sum - visitorCnt[i - period] + visitorCnt[i];
                maxVisitor = Math.max(sum, maxVisitor);
            }
            else {
                sum += visitorCnt[i];
                if(i == period - 1) maxVisitor = sum;
            }
        }
        return maxVisitor;
    }

    public static long searchPeriodCnt(long maxVisitor) {
        long sum = 0;
        long cnt = 0;

        for(int i = 0; i < afterStart; i++) {
            if(i >= period) {
                sum = sum - visitorCnt[i - period] + visitorCnt[i];
                if(sum == maxVisitor) cnt++;
            }
            else {
                sum += visitorCnt[i];
                if(i == period - 1 && sum == maxVisitor)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        afterStart = Integer.valueOf(stz.nextToken());
        period = Integer.valueOf(stz.nextToken());

        visitorCnt = new int[afterStart];

        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < afterStart; i++) {
            visitorCnt[i] = Integer.valueOf(stz.nextToken());
        }

        long maxVisitor = searchMaxVisitor();
        long periodCnt = searchPeriodCnt(maxVisitor);

        if(maxVisitor == 0) {
            System.out.println("SAD");
            return;
        } else
            System.out.println(maxVisitor);
        System.out.println(periodCnt);

    }
}
