import java.util.ArrayList;

import java.lang.reflect.Array;

public class MostRainWater {

// brute force

//     public static int mostWater(ArrayList<Integer> list) {
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<list.size();i++){
//             int curr = list.get(i);
//             for(int j=i+1;j<list.size();j++){
//                 int height = Math.min(curr,list.get(j));
//                 int width = j - i;
//                 int area = height * width;
//                 max = Math.max(max,area);  
//             }
//         }
//         return max;
// }

// 2 pointer approach

public static int mostWater(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;
    int lp = 0;
    int rp = list.size()-1;
    while(lp<rp){
        int height = Math.min(list.get(lp),list.get(rp));
        int width = rp - lp;
        int area = height * width;
        max = Math.max(max,area);  
        if(list.get(lp)<list.get(rp)){
            lp++;
        }else{
            rp--;
        }
    }
    return max;
}
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(8);
        list.add(6);list.add(2);
        list.add(5);list.add(4);
        list.add(8);list.add(3);
        list.add(7);
        System.out.println(mostWater(list));
        // mostWater(list);
        
    }
}
