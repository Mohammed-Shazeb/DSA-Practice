package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class MergeBst {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node createBst(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei)
            return null;
        int mid = si + (ei - si) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBst(arr, si, mid - 1);
        root.right = createBst(arr, mid + 1, ei);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2, arr2);
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                result.add(arr1.get(i++));
            } else {
                result.add(arr2.get(j++));
            }
        }

        while (i < arr1.size())
            result.add(arr1.get(i++));
        while (j < arr2.size())
            result.add(arr2.get(j++));
        return createBst(result, 0, result.size() - 1);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         * 2
         * / \
         * 1 4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         * 9
         * / \
         * 3 12
         */

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preorder(root);

        /*
         * 3
         * /\ \
         * 1 2 4 9 12
         */

        // System.out.println("Inorder traversal of the merged BST:");
        // ArrayList<Integer> mergedInorder = new ArrayList<>();
        // inorder(root, mergedInorder);
        // System.out.println(mergedInorder);
    }
}
