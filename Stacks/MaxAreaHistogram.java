package Stacks;

import java.util.*;

public class MaxAreaHistogram {
    public static void MaxArea(int arr[]){
        int maxArea = 0;
        int nrs[] = new int[arr.length];
        int nls[] = new int[arr.length];

        //nrs
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int curr = arr[i];
            while(!s.isEmpty() && arr[s.peek()] >= curr){
                s.pop();   
            }
            if(s.isEmpty()){
                nrs[i] = arr.length;
            }
            else{
                nrs[i] = s.peek();
            }
            s.push(i);
        }
        //nls
        s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            int curr = arr[i];
            while(!s.isEmpty() && arr[s.peek()] >= curr){
                s.pop();   
            }
            if(s.isEmpty()){
                nls[i] = -1;
            }
            else{
                nls[i] = s.peek();
            }
            s.push(i);
        }
        //area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nrs[i]-nls[i]-1;
            int area = height*width;
            maxArea = Math.max(area,maxArea);
        }
        System.out.println("The max area is "+maxArea);
    }
    
    public static void main(String[] args) {
        int arr[] = {2,4};
        MaxArea(arr);
    }
}
