package Graphs;
import java.util.*;
/*
A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U.
We can also say that there is no edge that connects vertices of same set.

-1 = no color
 0 = color yellow
 1 = color blue

Case 1: neighbor -> color not there so we assign opp. color 
Case 2: neighbor -> color -> diff will do smtg.
Case 3: neighbor -> color -> same ==> results in false.

If a graph is acyclic then it is bipartite.
If a graph is Even then it is bipartite.
If a graph is Odd then it is not bipartite. 

*/

public class Bipartite {

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
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        
        for(int i=0; i<graph.length; i++) {
            color[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                q.add(i);
                color[i] = 0; // yellow

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if(color[e.dest] == -1) {
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // If a graph does not contain cycle, then it is bipartite.
        /*
              0 ------2
             /       /
            /       /
           1       4 
            \     /
             \   /
               3  
        */

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
    
}
