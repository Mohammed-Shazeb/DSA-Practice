// import java.util.ArrayList;

// public class ques {
//     public static void beautifulArr(ArrayList<Integer> list, int n){
//         if(n == 1){
//             list.add(1);
//             return;
//         }
//         ArrayList<Integer> list1 = new ArrayList<>();
//         ArrayList<Integer> listOdd = new ArrayList<>();
//         ArrayList<Integer> listEven = new ArrayList<>();
//         beautifulArr(list1, n/2);
//         for(int i = 0; i<list1.size();i++){
//             int a= list1.get(i);
//             if (2 * a-1 <= n) {
//                 listOdd.add(2 * a-1);
//             }
//             if (2 * a <= n) {
//                 listEven.add(2 * a);
//             }
//             // listOdd.add(2*a -1);
//             // listEven.add(2*a );
//         }
//         // for(int i = 0; i<list1.size();i++){
//         // }
//         list.addAll(listOdd);
//         list.addAll(listEven);
//         return;
//     }
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         beautifulArr(list, 7);
//         System.out.println(list);
//     }
// }

import java.util.ArrayList;
import java.util.Collections;

public class pra {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.size() == 0)
            return list;

        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);

            boolean isDuplicate = (i > 0 && nums.get(i - 1).equals(curr)) ||
                    (i < nums.size() - 1 && nums.get(i + 1).equals(curr));
            boolean hasPrevNeighbor = (i > 0 && nums.get(i - 1) == curr - 1);
            boolean hasNextNeighbor = (i < nums.size() - 1 && nums.get(i + 1) == curr + 1);

            if (!isDuplicate && !hasPrevNeighbor && !hasNextNeighbor) {
                list.add(curr);
            }
        }

        return list;
    }

    // public static void main(String[] args) {
    // ArrayList<Integer> input = new ArrayList<>();
    // Collections.addAll(input, 10, 6, 5, 8);

    // ArrayList<Integer> lonelyNumbers = findLonely(input);
    // System.out.println("Lonely Numbers: " + lonelyNumbers);
    // }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
                // System.out.println(result[nums.get(i + 1) - 1]++);
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
                System.out.println(ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        Collections.addAll(num, 1, 100, 200, 1, 100);
        int result = mostFrequent(num, 1);
        System.out.println(result);
    }
}
