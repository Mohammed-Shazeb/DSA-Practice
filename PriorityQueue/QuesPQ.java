package PriorityQueue;

import java.util.*;

// import PriorityQueue.PQ.Student;

public class QuesPQ {

    /*
    this is k closest points to origin
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;

        public Point(int x, int y, int distSq) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }
    */ 

    public static void main(String[] args) {
        /*
         * This is for k closest points to origin
         int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
         int k = 2;
 
         PriorityQueue<Point> pq = new PriorityQueue<>();
 
         for (int i = 0; i < pts.length; i++) {
             int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
             pq.add(new Point(pts[i][0], pts[i][1], distSq));
         }
 
         for (int i = 0; i < k; i++) {
             Point p = pq.remove();
             System.out.println("(" + p.x + ", " + p.y + ")");
         }
        */

        /*  -------------------------------------------------------------------------------------------------------------

        Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, 
        such that the cost to connect two ropes is equal to the sum of their lengths.
        */
        int ropes[] = { 4, 3, 2, 6 };
        // 2+3 => (5) =>  4 5 6 => 4+5 =>(9) => 6+9 => (15)   total cost = 5 + 9 + 15 = 29 
        //  4 5 6  => 9 6 => 15
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();

            cost += min + min2;
            pq.add( min + min2);
        }
        System.out.println("Total cost to connect ropes: " + cost);

    }

}
