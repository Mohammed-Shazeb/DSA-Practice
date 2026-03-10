package Graphs;

import java.util.ArrayList;

/*
An articulation point (or cut vertex) in a graph is a vertex that, if removed (along with its incident edges), 
increases the number of connected components in the graph, 
essentially disconnecting it or breaking a connected network into separate pieces. 
These points represent critical vulnerabilities in networks, as their failure disrupts connectivity.
Finding them efficiently involves using Depth-First Search (DFS) 
and keeping track of discovery times and lowest reachable ancestors (Tarjan's Algorithm). 
*/

public class ArticulationPoint {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean vis[], int time,
            boolean AP[]) {
        vis[curr] = true;

        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1: parent
            if (e.dest == parent)
                continue;

            // case 2: unvisited
            else if (!vis[e.dest]) {
                dfs(graph, e.dest, curr, dt, low, vis, time, AP);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // check condition for articulation point
                if (parent != -1 && dt[curr] <= low[e.dest]) {
                    AP[curr] = true;
                }
                children++;
            }

            // case 3: visited
            else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
        if (parent == -1 && children > 1) {
            AP[curr] = true;
        }
    }

    public static void tarjanAlgo(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean AP[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, AP);
            }
        }

        // Print
        for (int i = 0; i < V; i++) {
            if (AP[i]) {
                System.out.println("Node " + i + " is an articulation point: ");
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanAlgo(graph, V);
    }
}
