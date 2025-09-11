package Binary_Tree;

import java.util.*;

public class Height {
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

    public static int height(Node root) {
        if (root == null)
            return 0;

        int lf = height(root.left);
        int rf = height(root.right);
        return Math.max(lf, rf) + 1;
    }

    public static int count(Node root) {
        if (root == null)
        return 0;

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
        }

        public static int sumOfNodes(Node root) {
        if (root == null)
        return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int selfDiameter = lh + rh + 1;
        int res = Math.max(selfDiameter, Math.max(ld, rd));
        return res;
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;

        }
    }

    public static Info diameterNew(Node root) {
        if (root == null)
            return new Info(0, 0);
        Info leftInfo = diameterNew(root.left);
        Info rightInfo = diameterNew(root.right);
        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht
                + rightInfo.ht + 1);
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(diameter, height);
    }

    // subtree of an another tree
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot))
                return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        /*
         * subTree
         * 2
         * / \
         * 4 5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        /*
         * main tree
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println("Height of the tree: " + height(root));
        // System.out.println("Count of nodes in the tree: " + count(root));
        // System.out.println("Sum of all nodes in the tree: " + sumOfNodes(root));
        // System.out.println("Diameter of the tree: " + diameter(root));
        // System.out.println("New Diameter of the tree: " + (diameterNew(root).diam));
        // System.out.println("Is subRoot a subtree of root? " + isSubtree(root,
        // subRoot));

    }

}
