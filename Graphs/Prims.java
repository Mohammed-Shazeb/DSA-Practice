package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;
        int parent;

        public Pair(int v, int cost, int parent) {
            this.v = v;
            this.cost = cost;
            this.parent = parent;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        ArrayList<String> list = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, -1));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.v]) {
                vis[curr.v] = true;

                finalCost += curr.cost;
                if (curr.parent != -1) {
                    list.add(curr.parent + " --(" + curr.cost + ")--> " + curr.v);
                }
                // list.add(curr.cost);

                // for(int i=0; i<graph[curr.v].size(); i++) {
                // Edge e = graph[curr.v].get(i);
                // pq.add(new Pair(e.dest, e.wt));
                // }
                for (Edge e : graph[curr.v]) {
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt, curr.v));
                    }
                }
            }
        }
        System.out.println("Final cost of MST: " + finalCost);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
