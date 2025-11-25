package HashMap;

import java.util.*;

public class FindItenary {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();
        
        for(String key: tickets.keySet()){
            reverseMap.put(tickets.get(key), key);
        }
        for(String key: tickets.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Banglore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        
        String start = getStart(tickets);
        System.out.print(start);

        for(String key: tickets.keySet()){
            String dest = tickets.get(start);
            System.out.print(" -> " + dest);
            start = dest;
        }
    }
}