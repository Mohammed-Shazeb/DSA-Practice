package Graphs;

import java.util.ArrayList;

public class BridgeInAGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    
    // Store bridges
    static ArrayList<String> bridges = new ArrayList<>();


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
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 3));
    graph[5].add(new Edge(5, 4));

    }

    // static void createGraph(ArrayList<Edge>[] graph) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     // 0 - 1
    //     graph[0].add(new Edge(0, 1));
    //     graph[1].add(new Edge(1, 0));

    //     // 1 - 2
    //     graph[1].add(new Edge(1, 2));
    //     graph[2].add(new Edge(2, 1));

    //     // 2 - 3
    //     graph[2].add(new Edge(2, 3));
    //     graph[3].add(new Edge(3, 2));

    //     // 3 - 0
    //     graph[3].add(new Edge(3, 0));
    //     graph[0].add(new Edge(0, 3));
    // }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean vis[],
            int time) {
        vis[curr] = true;

        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1: parent
            if (e.dest == parent)
                continue;

            // case 2: unvisited
            else if (!vis[e.dest]) {
                dfs(graph, e.dest, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // check condition for bridge
                if (dt[curr] < low[e.dest]) {
                    bridges.add(curr + " - " + e.dest);
                    // System.out.println("Bridge found between nodes: " + curr + " - " + e.dest);
                }
            }

            // case 3: visited
            else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void tarjanAlgo(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
        if (bridges.isEmpty()) {
            System.out.println("No bridges found in the graph");
        } else {
            for (String bridge : bridges) {
                System.out.println("Bridge found between nodes: " + bridge);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanAlgo(graph, V);
    }
}
