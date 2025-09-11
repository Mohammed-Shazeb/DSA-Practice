package Stacks;
import java.util.*;
// import java.util.LinkedList;
// import java.util.Stack;

public class stacksLinkedList{
//     public static class Node{
//         int data;
//         Node next;
//         // Node tail;
//         public Node (int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//     public class Stacks{
//         public static Node head = null;
//         public static Node tail;
//         public static int size;

//         public static boolean isEmpty(){
//             return head == null;
//         }

//         public static void push(int data){
//             Node newNode = new Node(data);

//             if (isEmpty()) {
//                 head = newNode;
//                 return;
//             }
//             newNode.next = head;
//             head = newNode;
//         }

//         public static int pop(){
//             if(isEmpty()){
//                 return -1;
//             }
//             int val = head.data;
//             head = head.next;
//             return val;
//         }
//         public static int peek(){
//             if(isEmpty()){
//                 return -1;
//             }
//             return head.data;
//         }
       
//     }
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverse(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        } 
        return result.toString();
    }
    
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printRS(Stack<Integer> s){
        while(!s.isEmpty()){
            System.err.println(s.pop());
        }
    }
    public static void main(String[] args) {
        // Stack s = new Stacks();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);   
        s.push(3);
        s.push(4);
        reverseStack(s);
        printRS(s);
        // s.push(5);
        // pushAtBottom(s,10);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
        // String str = "abcd";
        // String result = reverse(str);
        // System.out.println(result);
        // System.out.println(s.pushAtBottom(s,0));
        
        // s.pushAtBottom(s,0);
    }
}




