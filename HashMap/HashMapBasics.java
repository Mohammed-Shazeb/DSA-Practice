package HashMap;
import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert key-value pairs into the HashMap
        hm.put("China", 1);
        hm.put("India", 2);
        hm.put("USA", 3);
 
        System.out.println(hm);

        // Get value for a specific key
        int value = hm.get("India");
        System.out.println("Value for key 'India': " + value);

        // containsKey
        System.out.println(hm.containsKey("USA"));

        // Remove a key-value pair
        hm.remove("China");
        System.out.println(hm);

        // Size of the HashMap
        System.out.println("Size of HashMap: " + hm.size());

        // isEmpty
        System.out.println("Is HashMap empty? " + hm.isEmpty());

        hm.clear();  // Clear the HashMap
        System.out.println("Is HashMap empty after clear? " + hm.isEmpty());
    }
}
