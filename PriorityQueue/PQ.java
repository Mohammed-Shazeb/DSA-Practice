package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    int roomNumber;

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // Priority Queue example with integers: 1, 2, 3, 4, 5
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //reverse order
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Alice", 3)); // O(log n)
        pq.add(new Student("Bob", 4));
        pq.add(new Student("Charlie", 1));
        pq.add(new Student("David", 7));
        
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name +" -> "+ pq.peek().rank); // O(1)
            pq.remove(); // Remove the element after printing
        }
    }
}