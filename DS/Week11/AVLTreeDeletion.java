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

    TreeNode rightRotate(TreeNode z) {
        TreeNode y = z.left;
        TreeNode T2 = y.right;

        y.right = z;
        z.left = T2;

        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    TreeNode leftRotate(TreeNode z) {
        TreeNode y = z.right;
        TreeNode T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = Math.max(height(z.left), height(z.right)) + 1;
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

    TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                TreeNode temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                TreeNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
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
        System.out.println();

        tree.root = tree.deleteNode(tree.root, 40);
        System.out.println("Inorder traversal after deletion of 40:");
        tree.inOrder(tree.root);
    }
}
