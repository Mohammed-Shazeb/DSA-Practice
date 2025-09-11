// Given an array of integers, find the next greater element for each element in the array.
// The next greater element of an element x is the first element to the right of x in the array that is greater than x. 
// If there is no greater element, assign -1 for that position.
// Return the result as a new array.
// 🧪 Example
// Input: arr = [6, 8, 0, 1, 3]
// Output:[8, -1, 1, 3, -1]

package Stacks;

import java.util.*;

public class nextGreater {
    public static void main(String[] args) {
        // int arr[] = {5,9,1,4,8};
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        
        System.out.println(Arrays.toString(nextGreater));
    }
}
