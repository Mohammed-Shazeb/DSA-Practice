package HashMap;
import java.util.*;

public class LinkedHM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();  // maintains insertion order

        lhm.put("India", 1);
        lhm.put("USA", 2);
        lhm.put("China", 3);
        lhm.put("UK", 4);
        lhm.put("Russia", 5);
        System.out.println(lhm);
        // -----------------------------------------------------------
        LinkedHashSet<String> lhs = new LinkedHashSet<>();  // maintains insertion order
        lhs.add("India");
        lhs.add("USA");
        lhs.add("China");
        lhs.add("UK");
        lhs.add("Russia");
        System.out.println(lhs);
        // ------------------------------------------------------------

        HashMap<String, Integer> hm = new HashMap<>();  // no order
        hm.put("India", 1);
        hm.put("USA", 2);
        hm.put("China", 3);
        hm.put("UK", 4);
        hm.put("Russia", 5);
        System.out.println(hm);

        TreeMap<String, Integer> tm = new TreeMap<>();  // sorted order
        tm.put("India", 1);
        tm.put("USA", 2);
        tm.put("China", 3);
        tm.put("UK", 4);
        tm.put("Russia", 5);
        System.out.println(tm);

        TreeSet<String> ts = new TreeSet<>();  // sorted order  
        ts.add("India");
        ts.add("USA");
        ts.add("China");
        ts.add("UK");
        ts.add("Russia");
        System.out.println(ts);
    }
}
