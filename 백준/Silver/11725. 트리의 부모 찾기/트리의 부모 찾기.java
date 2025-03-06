import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<List<Integer>> edge = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int[] parentNodes;

    public static void bfs() {
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            List<Integer> childNodes = edge.get(currentNode);

            for (int childNode : childNodes) {
                if (!visited[childNode]) {
                    queue.add(childNode);
                    visited[childNode] = true;
                    parentNodes[childNode] = currentNode;
                }
            }
        }
    }

    public static void output() {
        StringBuilder sb = new StringBuilder();

        for(int i = 2; i < parentNodes.length; i++) {
            sb.append(parentNodes[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());

        visited = new boolean[nodeCnt + 1];
        parentNodes = new int[nodeCnt + 1];

        int edgeCnt = nodeCnt - 1;

        for(int i = 0; i < nodeCnt + 1; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] nodes = br.readLine().split(" ");

            int parent = Integer.parseInt(nodes[0]);
            int child = Integer.parseInt(nodes[1]);

            edge.get(parent).add(child);
            edge.get(child).add(parent);
        }

        bfs();

        output();

    }
}
