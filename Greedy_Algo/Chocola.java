// We are given a bar of chocolate composed of mxn square pieces. 
//One should break the chocolate into single squares. 
//Each break of a part of the chocolate is charged a cost expressed by a positive integer. 
//This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. 
//Let us denote the costs of breaking along consecutive vertical lines with * 1 ,*2,....,xm-1 and along horizontal lines with y 1,y2,....,yn-1
// Compute the minimal cost of breaking the whole chocolate into single squares.

package Greedy_Algo;

import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        Arrays.sort(costVer, Comparator.reverseOrder()); // sort in descending order
        Arrays.sort(costHor, Comparator.reverseOrder()); // sort in descending order

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;

        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;

        }
        System.out.println("the cost of the chocolate is " + cost);
    }

}
