import java.util.*;

class Graph{
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    private int V;
    private List<Edge> edges;

    public Graph(int vertices) {
        this.V = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        Edge edge = new Edge();
        edge.src = u;
        edge.dest = v;
        edge.weight = w;
        edges.add(edge);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    public void KruskalMST() {
        List<Edge> result = new ArrayList<>();
        int[] parent = new int[V];
        int[] rank = new int[V];

        Collections.sort(edges);

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int edgeCount = 0;
        for (Edge edge : edges) {
            if (edgeCount == V - 1) break;

            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                result.add(edge);
                edgeCount++;
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(7, 6, 1);
        g.addEdge(8, 2, 2);
        g.addEdge(6, 5, 2);
        g.addEdge(0, 1, 4);
        g.addEdge(2, 5, 4);
        g.addEdge(8, 6, 6);
        g.addEdge(2, 3, 7);
        g.addEdge(7, 8, 7);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(3, 4, 9);
        g.addEdge(5, 4, 10);
        g.addEdge(1, 7, 11);
        g.addEdge(3, 5, 14);

        g.KruskalMST();
    }
}
