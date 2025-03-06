import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int nodeCnt,root, targetNode, pareCnt;
    public static List<List<Integer>> edge = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int[] distance;

    public static void createEdge() {
        for (int i = 0; i < nodeCnt + 1; i++) {
            edge.add(new ArrayList<>());
        }
    }

    public static void bfs() {
        queue.add(root);
        visited[root] = true;
        distance[root] = 0;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            List<Integer> children = edge.get(currentNode);

            for(int i = 0; i < children.size(); i++) {
                int childNode = children.get(i);
                if(!visited[childNode]) {
                    queue.add(childNode);
                    visited[childNode] = true;
                    distance[childNode] = distance[currentNode] + 1;

                    if(childNode == targetNode) {
                        System.out.println(distance[childNode]);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCnt = Integer.parseInt(br.readLine());

        visited = new boolean[nodeCnt + 1];
        distance = new int[nodeCnt + 1];

        String[] nodes = br.readLine().split(" ");

        root = Integer.parseInt(nodes[0]);
        targetNode = Integer.parseInt(nodes[1]);

        pareCnt = Integer.parseInt(br.readLine());

        createEdge();

        for(int i = 0; i < pareCnt; i++){
            nodes = br.readLine().split(" ");
            int parentNode = Integer.parseInt(nodes[0]);
            int childNode = Integer.parseInt(nodes[1]);

            edge.get(parentNode).add(childNode);
            edge.get(childNode).add(parentNode);
        }

        bfs();

    }
}
