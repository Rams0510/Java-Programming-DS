class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    int findMinValue() {
        return findMinValueRec(root);
    }

    int findMinValueRec(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("Example 1:");
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        System.out.println("Minimum value in the BST: " + tree.findMinValue());

        System.out.println("\nExample 2:");
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(10);
        tree2.insert(15);
        tree2.insert(12);
        System.out.println("Minimum value in the BST: " + tree2.findMinValue());
    }
}
