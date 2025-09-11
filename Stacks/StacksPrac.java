package Stacks;

import java.util.*;

public class StacksPrac {
    public static String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String curr = str[i];

            if (curr.equals(".") || curr.equals("")) {
                continue;
            } 
            // else if (curr.equals("")){
            //     if (!s.isEmpty()) {
            //         s.pop();
            //     }
            // } 
            else if (curr.equals("..") ) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(str[i]);
            }
        }
        String result = "";
        while (!s.isEmpty()) {
            result = "/" + s.pop() + result;

        }
        if(result.equals("")){
            return "/";
        }
        return result;
    }

    public static void main(String[] args) {
        // String path = "/home//user/.././folder/...//stacks/";
        String path = "/../";

        System.out.println(simplifyPath(path));
    }
}
