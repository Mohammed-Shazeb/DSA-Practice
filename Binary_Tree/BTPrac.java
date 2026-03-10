package Binary_Tree;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BTPrac {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BT {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static boolean univalued(Node root) {
            if (root == null) {
                return true;
            }
            if (root.left != null && root.data != root.left.data)
                return false;
            if (root.right != null && root.data != root.right.data)
                return false;

            return univalued(root.left) && univalued(root.right);
        }

        public static Node removeLeafNodes(Node root, int target) {
            if (root == null)
                return null;

            if (root.data == target && root.left == null && root.right == null)
                return null;

            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);

            return root;
        }

        public static Node invert(Node root) { 
            if (root == null)
                return null;

            Node left = invert(root.left);
            Node right = invert(root.right);
            root.left = right;
            root.right = left;

            return root;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {

        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes[] = { 1, 2, 2, -1, -1, 5, -1, -1, 3, 2, 6, -1, -1 };

        BT tree = new BT();
        Node root = tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println();

        // if (tree.univalued(root)) {
        // System.out.println("Univalued Tree");
        // } else {
        // System.out.println("Not Univalued Tree");
        // }

        // tree.invert(root);
        // tree.preOrder(root);

        tree.removeLeafNodes(root, 2);
        tree.preOrder(root);
        System.out.println();
    }

}
