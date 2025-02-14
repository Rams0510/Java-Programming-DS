import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return other.weight - this.weight;
    }
}

class Graph {
    private int V;
    private List<Edge> edges;

    public Graph(int vertices) {
        this.V = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }

    private void dfs(int v, boolean[] visited, List<Edge> currentEdges) {
        visited[v] = true;

        for (Edge edge : currentEdges) {
            if (edge.src == v && !visited[edge.dest]) {
                dfs(edge.dest, visited, currentEdges);
            } else if (edge.dest == v && !visited[edge.src]) {
                dfs(edge.src, visited, currentEdges);
            }
        }
    }

    private boolean connected(List<Edge> currentEdges) {
        boolean[] visited = new boolean[V];
        if (!currentEdges.isEmpty()) {
            dfs(currentEdges.get(0).src, visited, currentEdges);
        }

        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    public void reverseDeleteMST() {
        Collections.sort(edges);
        List<Edge> mstEdges = new ArrayList<>(edges);

        for (Edge edge : edges) {
            mstEdges.remove(edge);
            if (!connected(mstEdges)) {
                mstEdges.add(edge);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        int mstWeight = 0;
        for (Edge edge : mstEdges) {
            System.out.println("(" + edge.src + ", " + edge.dest + ") - Weight: " + edge.weight);
            mstWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }
}

public class ReverseDeleteMST {
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        graph.reverseDeleteMST();
    }
}
