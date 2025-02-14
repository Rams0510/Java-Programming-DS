import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeInsertion {
    
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.left == null) {
                current.left = new Node(key);
                return root;
            } else {
                queue.add(current.left);
            }
            
            if (current.right == null) {
                current.right = new Node(key);
                return root;
            } else {
                queue.add(current.right);
            }
        }
        
        return root;
    }
    
    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        System.out.println("Original Tree (Level Order Traversal):");
        levelOrder(root);

        int key = 70;
        root = insert(root, key);

        System.out.println("Tree after inserting " + key + " (Level Order Traversal):");
        levelOrder(root);
    }
}
