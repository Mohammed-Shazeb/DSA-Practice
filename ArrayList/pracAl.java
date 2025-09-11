
// package ArrayList;
import java.lang.reflect.Array;
import java.util.*;
// import java.util.ArrayList;
// import java.util.Collections;

public class pracAl {
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static boolean monotonicArrayList(ArrayList<Integer> list, int i, int j) {
        while (i < j) {
            if (list.get(i) < list.get(j)) {
                return true;
            }
            i++;
        }
        return false;
    }

    // public static void isLonely(ArrayList<Integer> list){
    // ArrayList<Integer> res = new ArrayList<>();
    // for(int i=0;i<list.size();i++){
    // if(list.get(i)==list.get(i+1) || list.get(i)==list.get(i-1)) {
    // res.add(list.get(i));
    // }

    // }

    public static void mostFreq(ArrayList<Integer> list, int key) {
        int target = 0;
        // int max = Integer.MIN_VALUE;
        int freq[] = new int[1000];
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == key) {
                target = list.get(i + 1);

                freq[target]++;
            }
        }
        int maxFreq = 0;
        int result = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = i;
            }
        }
        System.out.println(result);
    }

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i) * 2 - 1 <= n)
                    temp.add(ans.get(i) * 2 - 1);
            }
            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i) * 2 <= n)
                    temp.add(ans.get(i) * 2);
            }
            ans = temp; // ✅ should be here
            // return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(100);
        // list.add(200);
        // list.add(1);
        // list.add(100);

        // System.out.println(list);
        // swap(list, 1, 3);
        // System.out.println(list);
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);
        // System.out.println(monotonicArrayList(list, 0, list.size()-1));
        // mostFreq(list, 1);
        System.out.println(beautifulArray(5));
        // beautifulArray(5);

    }
}
