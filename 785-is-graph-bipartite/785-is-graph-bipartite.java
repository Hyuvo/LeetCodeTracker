class Solution {
    boolean isBip = true;
    // default value for boolean array is false
    boolean[] visited;
    boolean[] color;
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        
        // the graph may not be fully connected
        // need to traverse from each node
        for (int i = 0; i < n; ++i) {
            if(!visited[i]) {
                traverse(graph, i);
            }
        }
        return isBip;
    }
    
    // traverse to neighbors from start, and dye
    public void traverse(int[][] graph, int start) {
        // if already know it's not biprtite
        if (!isBip) return;
        
        visited[start] = true;
        
        // traverse thru neighbors
        for (int neighbor : graph[start]) {
            // if not visited, dye with the opposite color
            if (!visited[neighbor]) {
                color[neighbor] = !color[start];
                traverse(graph, neighbor);
            } else { // if visited, compare colors
                if (color[neighbor] == color[start]) {
                    // if have same color, then it is not bip
                    isBip = false;
                    // terminate since we know the result
                    return;
                }
            }
        }
    }
}