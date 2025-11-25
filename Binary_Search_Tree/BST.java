package Binary_Search_Tree;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        } else{
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        else {
            return search(root.right, key);
        }
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val){
         if(root == null){
            return null;
        }
        if(root.data < val){
            root.right = delete(root.right, val);
        } 
        else if(root.data > val){
            root.left = delete(root.left, val);
        } 
        else{
            // case 1: no child
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2: one child
            else if(root.left == null){ 
                return root.right;
            } 
            // case 2: one child
            else if(root.right == null){
                return root.left;
            }
            // case 3: two child
            else{    
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }
    
    public static void printInRange(Node root , int k1, int k2){
        if(root == null){
            return;
        }
        else if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
   
    
    public static void PrintPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            PrintPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min,Node max){
        if(root == null)return true;

        if(min != null && root.data <= min.data)return false;
        else if(max != null && root.data >= max.data) return false;

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    public static Node mirror(Node root){
        if (root == null) return null;
        Node leftS = mirror(root.left);
        Node rightS = mirror(root.right);
        root.left = rightS;
        root.right = leftS;
        return root;
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
     

    // ------------------------------------------------------------------------
     public static void inorder(Node root, ArrayList<Integer>inorder){
        if(root == null) return;

        inorder(root.left,inorder);
        inorder.add(root.data);
        inorder(root.right,inorder);
    }
    public static Node buildBst(ArrayList<Integer> inorder, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        Node root = new Node(inorder.get(mid));

        root.left = buildBst(inorder, left, mid - 1);
        root.right = buildBst(inorder, mid + 1, right);

        return root;
    }
    public static Node balanceBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        //inorder
        inorder(root, inorder);

        // arrayList(sorted) -> bst
        return buildBst(inorder, 0, inorder.size() - 1);
    }

    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;
        public Info(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBst = 0;
    public static Info largestBst(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info leftInfo = largestBst(root.left);
        Info rightInfo = largestBst(root.right);

        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max); 
        } 

        if(leftInfo.isBst && rightInfo.isBst){
            maxBst = Math.max(maxBst, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    /*
     *      5
     *     / \
     *     1  7
     *     \
     *      3
     *     / \
     *     2  4
     *
     *
     *          8
     *        /  \
     *       5   10
     *      / \    \
     *     3  6    11
     *    / \        \
     *   1   4        14
     */
    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        // if (search(root, 1)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }

        // delete(root, 1);

        // inorder(root);
        // System.out.println();

        // System.out.println("Print in range:");
        // printInRange(root, 5, 12);

        // if(isValidBST(root, null, null)){
        //     System.out.println("\nThis is a valid BST");
        // } else{
        //     System.out.println("\nThis is not a valid BST");
        // }

        // root = mirror(root);
        // preorder(root);

        // System.out.println();
        // ArrayList<Integer> path = new ArrayList<>();
        balanceBST(root);
        preorder(root);

        Info info = largestBst(root);
        System.out.println("\nSize of largest BST is: "+maxBst);
    }

}
