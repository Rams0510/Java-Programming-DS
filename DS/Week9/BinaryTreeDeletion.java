import java.util.LinkedList;
import java.util.Queue;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}public class BinaryTreeDeletion {
   static Node getDeepestNode(Node root) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current = null;
        
        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return current;
    }

    static void deleteDeepest(Node root, Node dNode) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == dNode) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == dNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == dNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    static Node deletion(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node keyNode = null;
        Node temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (keyNode != null) {
            Node deepestNode = getDeepestNode(root);
            keyNode.data = deepestNode.data;
            deleteDeepest(root, deepestNode);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);

        System.out.println("Original Tree:");
        inorder(root);
        System.out.println();

        root = deletion(root, 10);

        System.out.println("Tree after deleting 10:");
        inorder(root);
        System.out.println();

        root = deletion(root, 20);

        System.out.println("Tree after deleting 20:");
        inorder(root);
    }
}
