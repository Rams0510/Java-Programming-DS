import java.util.ArrayList;
import java.util.List;

public class TreeBasicTerminologies {

    static void printChildren(int root, List<List<Integer>> adj) {
        if (adj.get(root).isEmpty()) {
            System.out.println("Node " + root + " has no children.");
        } else {
            System.out.print("Children of node " + root + ": ");
            for (int child : adj.get(root)) {
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }

    static void printLeafNodes(int root, List<List<Integer>> adj) {
        System.out.print("Leaf nodes: ");
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static void printDegrees(int root, List<List<Integer>> adj) {
        System.out.println("Degree of each node:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Node " + i + " has degree " + adj.get(i).size());
        }
    }

    public static void main(String[] args) {
        int n = 7;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);
        adj.get(5).add(6);

        printChildren(0, adj);
        printLeafNodes(0, adj);
        printDegrees(0, adj);
    }
}
