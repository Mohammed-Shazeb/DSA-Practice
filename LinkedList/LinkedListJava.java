package LinkedList;
public class LinkedListJava {
    public static class Node {
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class MyLinkedList {
        public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data){
            Node newNode = new Node(data);
            size++;
            if(head == null){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void addLast(int data){
            Node newNode = new Node(data);
            size++;
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;

        }

        public void print(){
            if(head == null){
                System.out.println("empty ll");
                return;
            }
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void add(int idx,int data){
            if(idx == 0){
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            int i = 0;
            while(i< idx-1){
                temp = temp.next;
                i++;
            }
            // intresting
            newNode.next=temp.next;
            temp.next = newNode;

        }

        public int removeFirst(){
            if(size == 0){
                System.out.println("empty LinkedList");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int  removeLast(){
            if(size == 0){
                System.out.println("empty LinkedList");
                return Integer.MIN_VALUE;
            }
            else if(size ==1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            } 
            Node prev = head;
            for(int i = 0; i<size-2;i++){
                prev = prev.next;
            }
            int val = tail.data;  //prev.next.data
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }

        public int itrSearch(int key){
            Node temp = head;
            int i = 0;
            while(temp !=null){
                if(temp.data == key){
                    // System.out.println("key found");
                    return i;                
                }
                temp = temp.next;
                i++;
            }

            return -1;
        }
        
        public int helperFun(Node head,int key){
            if(head == null){
                return -1;
            }
            if(head.data == key){
                return 0;
            }
            int idx = helperFun(head.next, key);
            if(idx == -1){
                return -1;
            }
            return idx+1;
        }

        public int recSearch(int key){
            return helperFun(head,key);
        }

        public void reverse(){
            Node prev = null;
            Node curr = tail = head;
            Node next;
            while (curr!= null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
       
        // remove nth from last i.e. n-i+1 from start
        public void removeNth(int n ){
            int size = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                size++;
            }
            if(n == size){
                head = head.next;
            }

            int i = 1;
            int prevNode = size - n;
            Node prev = head;
            while(i < prevNode){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }

        public Node findMid(Node head){
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public Boolean findPalindrome(){
            if(head == null || head.next == null){
                return true;
            }
            // find mid
            Node mid = findMid(head);

            // find 2nd half
            Node curr = mid.next;
            // mid.next = null;
            Node prev = null;
            Node next;
            while(curr!= null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node left = head;
            // check 1st half == 2nd half
            while(right!= null){
                if(right.data != left.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        public Boolean loopInACycle(){
            Node slow = head;
            Node fast = head;
            while (fast!= null && fast.next != null) {
                slow = slow.next;
                fast= fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }

        public static void removeCycle(){
            //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;
            while (fast!= null && fast.next != null) {
                slow = slow.next;
                fast= fast.next.next;
                if(slow == fast){
                    cycle = true;
                    break;
                }
            }  
            if(cycle == false){
                return; 
            } 

            // find meeting point 
            slow = head;
            Node prev = null;
            while(slow!= fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            //remove cycle 
            prev.next = null;
        }

        private Node getMid(Node head){
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;   
        }

        private Node merge(Node head1, Node head2){
            Node mergeLL = new Node(-1);
            Node temp = mergeLL;

            while(head1 !=null && head2 !=null){
                if(head1.data <= head2.data){
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next; 
                }
                else{
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                }
            }
            while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next; 
            }
            while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergeLL.next;
        }

        public Node mergeSort(Node head){
            if(head == null || head.next == null){
                return head;
            }

            Node mid = getMid(head);
            Node rightHead = mid.next;
            mid.next = null;
            Node newLeftMerge = mergeSort(head);
            Node newRightMerge = mergeSort(rightHead);

            return merge(newLeftMerge,newRightMerge);
        }

        public void zigZag(){

            // find mid 
            Node slow = head;
            Node fast = head.next;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;

            // find reverse second half
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            
            Node next; 
            while(curr!= null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node left = head;
            Node right = prev;
            Node nextL,nextR;
            
            // do the alternating merging
            while(left != null && right != null){
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;
                // update
                right = nextR;
                left = nextL;
            }
        }
    }

    public static void main(String args[]){
        MyLinkedList ll = new MyLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.print();
        ll.zigZag();
        ll.print();
        // ll.add(4,5);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // System.out.println(ll.size);
        // ll.print();
        // ll.removeLast();
        // ll.removeFirst();
        //System.out.println("this is itrSearch"+ll.itrSearch(3));
        // System.out.println("this is recSearch" + ll.recSearch(3));
        // System.out.println("this is recSearch" + ll.recSearch(13));
        //ll.print();  // Let's print it!
        //ll.reverse();
        // ll.removeNth(3);
        //System.out.println(ll.findPalindrome());
        // ll.print(); 
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // Node temp = new Node(3);
        // ll.head.next.next = temp;
        // ll.head.next.next.next = new Node(5);
        // ll.head.next.next.next.next = temp;  //1->2->3->4->1
        // System.out.println(ll.loopInACycle());
        // ll.removeCycle();
        // System.out.println(ll.loopInACycle());
        // ll.print();  
        // ll.head = ll.mergeSort(ll.head);   
        
    }
}
