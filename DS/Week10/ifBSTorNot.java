class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    boolean isBST(Node node) {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(8);

        if (tree.isBST(tree.root)) {
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(10);
        tree2.root.left = new Node(15);
        tree2.root.right = new Node(5);

        if (tree2.isBST(tree2.root)) {
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
