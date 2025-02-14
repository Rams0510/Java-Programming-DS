import java.util.*;

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class Best_FirstSearch {
    static int v = 14;
    static List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

    static void addedge(int x, int y, int cost) {
        graph.get(x).add(new Pair<>(y, cost));
        graph.get(y).add(new Pair<>(x, cost));
    }

    static void best_first_search(int actual_Src, int target, int n) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        boolean[] visited = new boolean[n];

        pq.add(new Pair<>(actual_Src, 0));
        visited[actual_Src] = true;

        System.out.println("Best First Search traversal:");

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int currentNode = current.first;

            System.out.print(currentNode + " ");

            if (currentNode == target) {
                System.out.println("\nTarget node " + target + " reached.");
                return;
            }

            for (Pair<Integer, Integer> neighbor : graph.get(currentNode)) {
                int neighborNode = neighbor.first;
                int edgeCost = neighbor.second;

                if (!visited[neighborNode]) {
                    visited[neighborNode] = true;
                    pq.add(new Pair<>(neighborNode, edgeCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        addedge(0, 1, 3);
        addedge(0, 2, 6);
        addedge(0, 3, 5);
        addedge(1, 4, 9);
        addedge(1, 5, 8);
        addedge(2, 6, 12);
        addedge(2, 7, 14);
        addedge(3, 8, 7);
        addedge(8, 9, 5);
        addedge(8, 10, 6);
        addedge(9, 11, 1);
        addedge(9, 12, 10);
        addedge(9, 13, 2);

        best_first_search(0, 11, v);
    }
}
