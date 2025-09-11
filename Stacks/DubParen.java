package Stacks;
import java.util.*;

public class DubParen {
    public static boolean findDubPar(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            int counter = 0;
            char ch = str.charAt(i);
            if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    counter++;
                }
                if (s.isEmpty()) return false;
                 
                if (counter < 1) {
                    return true;
                } else {
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        String str = "(a+(b)(c)-d)";
        System.out.println(findDubPar(str));
    }
}
