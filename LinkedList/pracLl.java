package LinkedList;

import java.util.*;

public class pracLl {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public Node intersectionOfTwoLinkedList(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;

        // Node common;
        while (a != b) {
            a = (a != null) ? a.next : head2;
            b = (b != null) ? b.next : head1;
        }
        return a;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("empty ll");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void oddEvenInter() {
        Node curr = head;
        Node prev = null;
        Node originalTail = tail;

        if (head == null || head.next == null)
            return;
        while (curr != null && curr != originalTail.next) {
            // even
            if (curr.data % 2 == 0) {
                prev = curr;
                curr = curr.next;
            } else { // odd
                Node nextNode = curr.next;

                if (curr == head) {
                    head = nextNode;
                } else {
                    prev.next = nextNode;
                }
                tail.next = curr;
                tail = curr;
                tail.next = null;
                // prev.next = prev.next.next;
                curr = nextNode;

            }
        }

    }

    public static void main(String[] args) {
        // pracLl ll = new pracLl();
        // Node common = new Node(4);
        // common.next = new Node(5);
        // Node headA = new Node(1);
        // headA.next = new Node(2);
        // headA.next.next = new Node(3);
        // headA.next.next.next = common;

        // Node headB = new Node(9);
        // headB.next = new Node(8);
        // headB.next.next = common;
        // Node intersectionNode = ll.intersectionOfTwoLinkedList(headA, headB);
        // if (intersectionNode != null) {
        // System.out.println("Intersection at node with data: " +
        // intersectionNode.data);
        // } else {
        // System.out.println("No intersection found");
        // }
        // LinkedList<Integer> ll = new LinkedList<>();
        pracLl ll = new pracLl();

        ll.addLast(8);
        ll.addLast(7);
        ll.addLast(6);
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.oddEvenInter();
        ll.print();
    }

}
