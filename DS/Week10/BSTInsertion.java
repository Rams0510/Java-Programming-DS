class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int val) {
        root = insertRec(root, val);
    }

    Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the BST:");
        tree.inorder();

        int keyToInsert = 40;
        System.out.println("\n\nInserting " + keyToInsert + " into the BST...");
        tree.insert(keyToInsert);

        System.out.println("Inorder traversal of the BST after insertion:");
        tree.inorder();
    }
}
