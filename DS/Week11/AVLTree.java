class TreeNode {
    int val, height;
    TreeNode left, right;

    TreeNode(int d) {
        val = d;
        height = 1;
    }
}

class AVL_Tree {
    TreeNode root;

    int height(TreeNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalance(TreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    TreeNode insert(TreeNode node, int key) {
        if (node == null)
            return new TreeNode(key);

        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.val)
            return rightRotate(node);

        if (balance < -1 && key > node.right.val)
            return leftRotate(node);

        if (balance > 1 && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder traversal of the AVL tree is:");
        tree.inOrder(tree.root);
    }
}
