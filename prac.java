// import java.util.ArrayList;

// public class prac {
//     public static int waterStoring(ArrayList<Integer> list){
//         int maxWater = 0;
//         for (int i = 0; i < list.size(); i++) {
//             for(int j = i+1;j<list.size();j++){
//                 int height = Math.min(list.get(i), list.get(j));
//                 int width = j-i;
//                 int water = height*width;
//                 maxWater = Math.max(water,maxWater);
//             }
//         }
//         return maxWater;
//     }
// public class prac{
//     public static int twoPointer(ArrayList<Integer> list){
//         int lp = 0;
//         int rp = list.size()-1;
//         int maxWater = 0;
//         while(lp < rp){
//             int ht = Math.min(list.get(lp),list.get(rp));
//             int wd = rp-lp;
//             int currWater = ht*wd;
//             maxWater = Math.max(currWater,maxWater);
//             if(list.get(lp)<list.get(rp)){
//                 lp++;
//             }
//             else{
//                 rp--;
//             }
//         }
//         return maxWater;
//     }
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         // 1 8 6 2 5 4 8 3 7
//         list.add(1); 
//         list.add(8);
//         list.add(6);
//         list.add(2);
//         list.add(5);
//         list.add(4);
//         list.add(8);
//         list.add(3);
//         list.add(7);
//         int result = twoPointer(list);
//         System.out.println(result);
//     }

// }

import java.util.ArrayList;

public class prac {
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        //finding pivot;
        int pivot= -1;
        int lp;
        int rp;
        int n = list.size();
        for(int i = 0;i<n;i++){
            if(list.get(i)>list.get(i+1)){
                pivot= i ;
                break;
            }
        }
        lp = pivot+1;
        rp = pivot;
        //while loop...
        while(lp!=rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;    
        }
            if(list.get(lp) + list.get(rp) < target){
                lp = (lp+1)%n;    
        }
            else 
        // (list.get(lp) + list.get(rp) > target){
               rp = (n + rp-1)%n;
            // return lp = (lp+1)%n;    
        }
        
        return false;
    }
    public static void main(String[] args) {
        int target = 16;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum2(list, target));
    }
}
