// package ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TwoDAl {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(3);innerList.add(5);innerList.add(2);innerList.add(3);
        mainList.add(innerList);
        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(3);innerList2.add(4);innerList2.add(1);innerList2.add(6);
        mainList.add(innerList2);
        // System.out.println(mainList);

        // now to print the both list number individually do the following steps
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            System.out.println(mainList.get(0));
            for(int j=0;j<currList.size();j++){
                // System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
            

    }
}
