package Graphs;

import java.util.*;

/*
Directed Acyclic Graph (DAG) is a directed graph with no cycles.
Topological sorting is used only for DAGs (not for non-DAGs)
It is a linear order of vertices such that every directed edge u -> v,
the vertex u comes before v in the order
*/

public class TopologicalSorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph [2].add(new Edge(2, 3));
        graph [3].add(new Edge(3, 1));
        graph [4].add(new Edge(4, 0));
        graph [4].add(new Edge(4,  1));
        graph [5].add(new Edge(5, 0));
        graph [5].add(new Edge(5, 2));

    }

    public static void topologicalSorting(ArrayList<Edge> graph[]) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        // visited[curr] = true;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortingUtil(graph, i, visited, s);
            }

        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortingUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                topologicalSortingUtil(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topologicalSorting(graph);

    }

}
