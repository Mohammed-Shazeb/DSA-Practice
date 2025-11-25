package Queue;
import java.util.*;
public class ReverseKElement {
 
    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) { 
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int count = 0;
        while (count<k && !q.isEmpty()) {
            s.push(q.remove());
            count++;
        }
        while (!s.isEmpty()) {
            queue.add(s.pop());
        }
        while (!q.isEmpty()) {
            queue.add(q.remove());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;
        // ReverseKElement rke = new ReverseKElement();
        Queue<Integer> result = reverseFirstK(q, k);
        while (!result.isEmpty()) {
            System.out.print(result.remove() + " ");
        }
        
    }
}
