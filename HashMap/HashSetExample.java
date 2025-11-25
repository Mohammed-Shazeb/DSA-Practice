package HashMap;

import java.util.*;

public class HashSetExample {

    // public static void main(String[] args) {
    // HashSet<Integer> hs = new HashSet<>();

    // // Adding elements
    // hs.add(10);
    // hs.add(20);
    // hs.add(30);
    // hs.add(20); // Duplicate, will not be added

    // System.out.println("HashSet: " + hs);

    // // Check if an element exists
    // System.out.println("Contains 20? " + hs.contains(20));
    // System.out.println("Contains 40? " + hs.contains(40));

    // // Remove an element
    // // hs.remove(10);
    // // System.out.println("After removing 10: " + hs);

    // // Size of the HashSet
    // // System.out.println("Size of HashSet: " + hs.size());

    // // Iterate through the HashSet
    // System.out.println("Iterating through HashSet:");
    // for (Integer num : hs) {
    // System.out.println(num);
    // }

    // // Iterate using HashSet iterator
    // System.out.println("Iterating using Iterator:");
    // Iterator<Integer> iterator = hs.iterator();
    // while (iterator.hasNext()) {
    // System.out.println(iterator.next());
    // }

    // }

    public static void main(String[] args) {
        int arr[] = { 7, 3, 9 };
        int arr2[] = { 6, 4, 3, 2, 9, 5 };

        // HashSet<Integer> hs = new HashSet<>();
        // for (int num : arr) {
        //     hs.add(num);
        // }
        // for (int num : arr2) {
        //     hs.add(num);
        // }

        // HashSet<Integer> hs = new HashSet<>();
        // for (int num : arr) {
        //     hs.add(num);
        // }

        // int count = 0;
        // for(int num : arr2){
        //     if(hs.contains(num)){
        //         count++;
        //         hs.remove(num);
        //     }
        // }
        // System.out.println("Count of common elements: " + count);

        HashSet<Integer> hs = new HashSet<>();
        for (int num : arr) {
            hs.add(num);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int num : arr2) {
            // ✅ Only add if element exists in both
            if (hs.contains(num)) {
                intersection.add(num);
            }
        }


        System.out.println("Combined HashSet: " + hs);
    }
}
