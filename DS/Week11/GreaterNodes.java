class TreeNode {
    int key, height, desc;
    TreeNode left, right;

    TreeNode(int d) {
        key = d;
        height = 1;
        desc = 1;
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

    int getDesc(TreeNode node) {
        if (node == null)
            return 0;
        return node.desc;
    }

    void updateNode(TreeNode node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
            node.desc = 1 + getDesc(node.left) + getDesc(node.right);
        }
    }

    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        updateNode(y);
        updateNode(x);

        return x;
    }

    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        updateNode(x);
        updateNode(y);

        return y;
    }

    TreeNode insert(TreeNode node, int key) {
        if (node == null)
            return new TreeNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        updateNode(node);

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    int countGreaterThan(TreeNode node, int x) {
        if (node == null)
            return 0;

        if (node.key <= x) {
            return countGreaterThan(node.right, x);
        } else {
            return 1 + getDesc(node.right) + countGreaterThan(node.left, x);
        }
    }

    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();

        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 6);

        int x = 5;
        int count = tree.countGreaterThan(tree.root, x);
        System.out.println("Number of elements greater than " + x + ": " + count);
    }
}
