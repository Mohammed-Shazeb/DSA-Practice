package Binary_Search_Tree;

public class AVLTrees {

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    // Get height of a node
    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node
    public static int getBalance(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    // Insert a node
    public static Node insert(Node root, int key) {

        // Normal BST insertion
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root; // Duplicate keys not allowed

        // Update height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor
        int bf = getBalance(root);

        // LL Case
        if (bf > 1 && key < root.left.data)
            return rightRotate(root);

        // RR Case
        if (bf < -1 && key > root.right.data)
            return leftRotate(root);

        // LR Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Get node with minimum value
    public static Node getMinNode(Node root) {
        Node curr = root;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    // Delete a node
    public static Node deleteNode(Node root, int key) {

        // Standard BST delete
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {

            // Node with one child or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child
                if (temp == null) {
                    root = null;
                }
                // One child
                else {
                    root = temp;
                }
            }
            // Node with two children
            else {
                Node temp = getMinNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If tree had only one node
        if (root == null)
            return root;

        // Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get balance factor
        int bf = getBalance(root);

        // LL Case
        if (bf > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR Case
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR Case
        if (bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL Case
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
         * 30
         * / \
         * 20 40
         * / \ \
         * 10 25 50
         */

        preorder(root);
    }
}
