import java.util.*;

class DFS {
    private Map<Integer, List<Integer>> graph;

    public DFS() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public void performDFS(int v) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS from vertex " + v + ":");
        DFSUtil(v, visited);
        System.out.println();
    }

    private void DFSUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");

        for (int neighbor : graph.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.performDFS(1);

        DFS g2 = new DFS();
        g2.addEdge(2, 0);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(0, 1);
        g2.addEdge(3, 3);
        g2.addEdge(1, 3);

        g2.performDFS(2);
    }
}
