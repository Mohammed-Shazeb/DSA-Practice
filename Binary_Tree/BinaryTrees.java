package Binary_Tree;

import java.util.*;

public class BinaryTrees {
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

    public static class BinaryTree {

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

        public static void preOrder(Node root) { // O(n)
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        
        public static void kthLevel(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevel(root.left, level+1, k);
            kthLevel(root.right, level+1, k);            
        }


        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);

            if(root.data == n){
                return true;
            }
            boolean left = getPath(root.left, n, path);
            boolean right = getPath(root.right, n, path);
            
            if(left || right){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }
        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            //lca
            int i=0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca =  path1.get(i-1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2){
            if(root == null){
                return null;
            }
            if(root.data == n1 || root.data == n2){
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }
            return root;
        }

        public static int lcaDist(Node root, int n){
            if(root == null) return -1;
            if(root.data == n) return 0;

            int ld = lcaDist(root.left, n);
            int rd = lcaDist(root.right, n);

            if(ld == -1 && rd == -1) return -1;
            else if(ld == -1) return rd+1;
            else return ld+1;

        }
        public static int minDist(Node root, int n1, int n2){
            int count = 0;
            Node lca = lca2(root, n1, n2);
            int d1 = lcaDist(lca, n1);
            int d2 = lcaDist(lca, n2);
            // System.out.println("Min distance is: "+(d1+d2));
            return d1+d2;
        }

        public static void levelOrderSumMax(Node root, int k) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
        
            q.add(root);
            
            // res.add(root.data);
            while (!q.isEmpty()) {
                int size = q.size();
                int maxSum = 0;
                for(int i=0;i<size;i++){
                    Node currNode = q.remove();
                    maxSum += currNode.data;

                    if (currNode.left != null) q.add(currNode.left);
                    if (currNode.right != null) q.add(currNode.right);
                }
                res.add(maxSum);
                
            }
            Collections.sort(res);
            for(int i: res){
                System.out.print(i+" ");
            }
            // System.out.println("Max sum is: "+res.get(res.size()-k));
        }

    }
    
    

    public static void main(String[] args) {
        /*
         * main tree
         *      1
         *     / \
         *    2   3
         *   / \   \
         *  4  5    6    
         */
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // tree.kthLevel(root, 0, 2);  // 4 5 6
        // System.out.println(tree.lca(root, 4, 5).data); //2
        System.out.println(tree.lca2(root, 4, 6).data); //1
        // tree.levelOrderSumMax(root, 2); // 4 5 6
        System.out.println(tree.minDist(root, 4, 6)); //3
    }
}
