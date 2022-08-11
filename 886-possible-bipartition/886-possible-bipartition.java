class Solution {
    boolean[] visited, color;
    boolean isBip = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);       
        // nodes start from 1
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        // subgraph may exist, need to start from each node
        for (int i = 1; i <= n; ++i) {
            if(!visited[i]) {
                traverse(graph, i);
            }
        }
        
        return isBip;
    }
    
    public void traverse(List<Integer>[] graph, int start) {
        // if is already not bipart, return
        if (!isBip) return;
        // dfs
        visited[start] = true;
        // see its neighbors
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                // if not visited, visit it and dye with the opposite color
                color[neighbor] = !color[start];
                traverse(graph, neighbor);
            } else{
                // if visited, compare color
                if (color[neighbor] == color[start]) {
                    isBip = false;
                }
            }
        }
        
    }
    
    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // CAUTION: labeled from 1 to n
        List<Integer>[] graph = new LinkedList[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        for (int[] pair : dislikes) {
            // CAUTION: undirected = bidirected
            int v = pair[0], w = pair[1];
            graph[v].add(w);
            graph[w].add(v);           
        }
        return graph;
    }
}