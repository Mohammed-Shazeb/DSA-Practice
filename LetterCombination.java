import java.lang.reflect.Array;
import java.util.*;

public class LetterCombination {
    public static void letterCombinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            letterCombinations(p + ch, up.substring(1));
        }
    }

    public static int letterCombinationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int digit = up.charAt(0) - '0';
        int count = 0;
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count += letterCombinationCount(p + ch, up.substring(1));
        }
        return count;
    }

    // static String[] keypad = {
    // "", // 0
    // "", // 1
    // "abc", // 2
    // "def", // 3
    // "ghi", // 4
    // "jkl", // 5
    // "mno", // 6
    // "pqrs", // 7
    // "tuv", // 8
    // "wxyz" // 9
    // };

    // public static ArrayList<String> letterCombinations(String p, String up) { //
    // p = processed and its is the result string
    // // up = unprocessed and this is the input string
    // if (up.isEmpty()) {
    // ArrayList<String> list = new ArrayList<>();
    // list.add(p);
    // return list;
    // }

    // int digit = up.charAt(0) - '0';
    // String letters = keypad[digit];
    // ArrayList<String> list = new ArrayList<>();

    // for (char ch : letters.toCharArray()) {
    // list.addAll(letterCombinations(p + ch, up.substring(1)));
    // }

    // return list;
    // }

    public static void main(String[] args) {
        // letterCombinations("", "23");
        System.out.println(letterCombinationCount("", "23"));
        
    }
}
