class Solution {
    boolean isBip = true;
    boolean[] color;
    boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        
        // the graph may not be conneted, need to traverse from each node
        for (int i = 0; i < n; ++i) {
            // if node i is not visited, visit node i
            if (!visited[i]) {
                traverse(graph, i);
            }            
        }
        
        return isBip;
    }
    
    public void traverse(int[][] graph, int start) {
        if (!isBip) return;
        visited[start] = true;       
        // see its neighbors
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                // if not visited, visit it and dye it with the other color
                color[neighbor] = !color[start];
                traverse(graph, neighbor);
            } else {
                // if have visited, compare the color to its neighbors;    
                if (color[start] == color[neighbor]) {
                    // if same color, set flag false
                    isBip = false;
                }                
            }
        }
    }
}