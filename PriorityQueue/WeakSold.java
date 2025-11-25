package PriorityQueue;

import java.util.*;

public class WeakSold {
    static class WeakestSoldier implements Comparable<WeakestSoldier> {
        int soldierCount;
        int rowIndex;

        public WeakestSoldier(int soldierCount, int rowIndex) {
            this.soldierCount = soldierCount;
            this.rowIndex = rowIndex;
        }

        @Override
        public int compareTo(WeakestSoldier ws2) {   // compareTo compares two objects of the class
            if (this.soldierCount == ws2.soldierCount) {
                return this.rowIndex - ws2.rowIndex;
            } else {
                return this.soldierCount - ws2.soldierCount;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 1 }};
        int k = 3;
        PriorityQueue<WeakestSoldier> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for(int j=0;j<army[i].length;j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new WeakestSoldier(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("Row " +pq.remove().rowIndex);
        }
    }
}
