import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(stz.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(stz.nextToken());

            switch(command) {
                case 1:
                    dq.addFirst(Integer.parseInt(stz.nextToken()));
                    break;
                case 2:
                    dq.addLast(Integer.parseInt(stz.nextToken()));
                    break;
                case 3:
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.removeFirst()).append("\n");
                    break;
                case 4:
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.removeLast()).append("\n");
                    break;
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    if(dq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case 7:
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;
                case 8:
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);

    }
}

