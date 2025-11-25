package HashMap;

import java.util.*;

public class SubArray {
    public static int subArrZero(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return len;
    }

    public static int subArrK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;

        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 15, 2, -2, -8, 1, 7, 10, 23 };
        System.out.print(subArrZero(arr));
    }
}
