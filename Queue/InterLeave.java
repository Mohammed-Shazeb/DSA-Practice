package Queue;

import java.util.*;

public class InterLeave {
    // static class Node {
    // int data;
    // Node next;

    // public Node (int data){
    // this.data = data;
    // this.next = null;
    // }
    // }
    // static Node head = null;
    // static Node tail = null;
    // public void interLeave(){
    // Node slow = head;
    // Node fast = head.next;

    // while(fast != null && fast.next != null){
    // slow = slow.next;
    // fast = fast.next.next;
    // }

    // Node mid = slow;
    // Node prev = mid.next;

    // mid.next = null;
    // Node left = head;
    // Node right = prev;
    // Node nextL,nextR;
    // while(left!= null && right!= null){
    // nextL = left.next;
    // left.next = right;
    // nextR = right.next;
    // right.next = nextL;

    // right = nextR;
    // left = nextL;
    // }
    // }

    public static void interLeave(Queue<Integer> q) {
        int n = q.size() / 2;
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q1.add(q.remove());
        }
        while (!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
    }
    
    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        //interLeave(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove()+" ");
        // }
        reverseQueue(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }

    }
}
