package Greedy_Algo;
import java.util.*;

public class KnapSack {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;
        double ratio[][] = new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = (value[i]/(double)weight[i]);
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = W;
        int totalValue = 0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                totalValue += value[idx];
                capacity -= weight[idx];
            }else{
                totalValue += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("The total value is "+totalValue);
    }
        
    // public static void main(String[] args) {
    //     int a[] = {1,2,3 };
    //     int b[] = {2,1,3};
    //     int finalValue;
    //     int result = 0;
    //     Arrays.sort(a);
    //     Arrays.sort(b);
    //     for(int i=0;i<a.length;i++){
    //         result += Math.abs(a[i] - b[i]); 
    //     }
    //     System.out.println(result);
    // }    
}
