package Queue;
import java.util.*;


public class MyDeque {
    static class stacks{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.peekLast();
        }
    }

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.peekFirst();
        }
    }
    public static void main(String[] args) {
        //@SuppressWarnings("rawtypes")
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // while(!s.isEmpty()){
        //     System.out.print(s.peek()+" ");
        //     s.pop();
        // }
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        
        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        
    }
}
