import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static List<List<int[]>> edges = new ArrayList<>();
    public static int[] values;

    public static void dijkstra(int root) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(values -> values[1]));
        queue.add(new int[]{root, 0});
        values[root] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currentPosition = node[0];

            List<int[]> childNodes = edges.get(currentPosition);

            for(int i = 0; i < childNodes.size(); i++) {
                int[] childNode = childNodes.get(i);
                int childPosition = childNode[0];
                int childValue = childNode[1];

                if(values[childPosition] > values[currentPosition] + childValue) {
                    values[childPosition] = values[currentPosition] + childValue;
                    queue.add(new int[]{childPosition, values[childPosition]});
                }
            }
        }
    }

    public static void output() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < values.length; i++) {
            int value = values[i];

            if(value == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nodesAndEdgesCount = br.readLine().split(" ");

        int nodeCnt = Integer.parseInt(nodesAndEdgesCount[0]);
        int edgeCnt = Integer.parseInt(nodesAndEdgesCount[1]);

        values = new int[nodeCnt + 1];
        Arrays.fill(values, Integer.MAX_VALUE);

        int root = Integer.parseInt(br.readLine());

        for(int i = 0; i < nodeCnt + 1; i++) {
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < edgeCnt; i++) {
            String[] twoNodeAndValue = br.readLine().split(" ");

            int startNode = Integer.parseInt(twoNodeAndValue[0]);
            int endNode = Integer.parseInt(twoNodeAndValue[1]);
            int value = Integer.parseInt(twoNodeAndValue[2]);

            edges.get(startNode).add(new int[]{endNode, value});
        }

        dijkstra(root);

        output();

    }
}
