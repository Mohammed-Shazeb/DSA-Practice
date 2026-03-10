package Graphs;
import java.util.*;

// a. Get nodes in stack (topological sort)
// b. Transpose the graph
// c. Do DFS according to stack nodes on the transpose graph
public class StronglyConnectedComponentKosaRajuAlgo {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> s, boolean vis[]) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        //Step 1: Topological sort
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                topSort(graph, i, s, vis);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge> transposedGraph[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            vis[i] = false;
            transposedGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); i++) {
                Edge e = graph[i].get(j);
                transposedGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3: DFS according to stack order
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC: ");
                dfs(transposedGraph, curr, vis);
                System.out.println();
            }
        }

        
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
