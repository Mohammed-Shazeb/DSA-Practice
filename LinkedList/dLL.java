package LinkedList;
public class dLL {
    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static class doubleLL{
        public static Node head;
        public static Node tail;
        public static int size;

        // addFirst
        public void addFirst(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
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
            newNode.prev = tail;
            tail = newNode;

        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.println("Null");
        }

        public int removeFirst(){
            if(size == 0){
                System.out.println("empty LinkedList");
                return Integer.MIN_VALUE;
            }
            if(size == 1){
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            }
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }

        public int removeLast(){
            // Node prev = head;
            // for(int i = 0; i < size -2;i++){
            //     prev = prev.next;
            // }
            if(size == 0){
                System.out.println("size is empty");
                return -1;
            }
            int val = tail.data;
            if(size == 1 ){
                head = tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
            }
            // prev.next = prev.next.next;
            // prev.next = null;
            // tail = prev;
            size--;
            return val;
        }
        public void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;
            while(curr !=null){
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next; 
            }
            head = prev;
        }
    }

    public static void main(String[] args) {
        doubleLL dLL = new doubleLL();
        // dLL.addFirst(4);
        // dLL.addFirst(3);
        // dLL.addFirst(2);
        // dLL.addFirst(1);
        dLL.addLast(1);
        dLL.addLast(2);
        dLL.addLast(3);
        dLL.addLast(4);
        dLL.print();
        // dLL.removeLast();
        dLL.reverse();
        dLL.print();
    }
}
