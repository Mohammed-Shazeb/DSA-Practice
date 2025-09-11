package Queue;
import java.util.*;

public class QueuePrac {
    // static class stack{
    //     Queue<String> q = new LinkedList<>();
    // }
    public static void generateBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(!q.isEmpty() && q.size() <=n){
            String s = q.remove();
            System.out.println(s);
            q.add(s+"0");
            q.add(s+"1");
        }

    }
    public static void connectNRopes(int arr[]){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int sum = 0;
        int finalSum = 0;
        for(int i=0;i<arr.length;i++){
            p.add(arr[i]);
        }
        while(p.size() > 1 ){
                int first = p.remove();
                int second = p.remove();
                sum = first + second;
                finalSum += sum;
            p.add(sum);
        }
        
        // System.out.println(sum);
        System.out.println(finalSum);
        // return finalSum;
        
    }
    public static void main(String[] args) {
        int arr[] = {4,3,2,6};
        // generateBinary(5);
        connectNRopes(arr);
    }
}
