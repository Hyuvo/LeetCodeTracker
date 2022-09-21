class Solution {
    // build a graph from dislikes, and see if bipartite
    boolean isBip = true;
    boolean[] visited;
    boolean[] color;
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // build graph from dislikes(edges)
        LinkedList<Integer>[] graph = buildGraph(dislikes, n);
        // node is 1-indexed
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        
        // the graph may not be fully connected
        // need to traverse from each node
        for (int i = 1; i <= n; ++i) {
            // if not traversed
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return isBip;
    }
    
    // traverse from start and dye
    public void traverse(LinkedList<Integer>[] graph, int start) {
        // if already know is not bip
        if (!isBip) return;
        // set visited true
        visited[start] = true;
        // traverse thru neighbors
        for (int neighbor : graph[start]) {
            // if not visited yet
            if (!visited[neighbor]) {
                // dye with opposit color and traverse
                color[neighbor] = !color[start];
                traverse(graph, neighbor);
            } else { // if visited, compare colors
                if (color[start] == color[neighbor]) {
                    // the graph is not bip
                    isBip = false;
                    return;
                }
            }
        }
    }
    
    public LinkedList<Integer>[] buildGraph (int[][] edges, int n) {
        // CAUTION: node is 1-indexed
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        // open space
        for (int i = 1; i <= n; ++i) {
            graph[i] = new LinkedList();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            // CAUTION: bidirected
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return graph;
    }
    
    
}