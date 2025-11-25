package HashMap;
import java.util.*;
public class HmIteration {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert key-value pairs into the HashMap
        hm.put("Apple", 10);
        hm.put("Banana", 20);
        hm.put("Orange", 30);
        hm.put("Grapes", 10);

        // Iterate using keySet()
        Set<String> keys = hm.keySet();
        System.out.println("Iteration using keySet():");
        for (String key : keys) {
            System.out.println("Key: " + key + ", Value: " + hm.get(key));
        }

        // Iterate using entrySet()
        System.out.println("\nIteration using entrySet():");   
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
