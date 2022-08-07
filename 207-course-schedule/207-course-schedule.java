class Solution {
    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph, if exists circular dependency, cannot finish
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        
        // not all nodes are connected, need to traverse from every node
        for (int i = 0; i < numCourses; ++i) {
            // traversal
            // see if cycle exists while traverse
            traverse(graph, i);
        }    
        
        // if there's no cycle in the graph, it is possible to finish all courses
        return !hasCycle;
        
        
    }
    
    public List<Integer>[] buildGraph(int numCourses, int[][] preReq) {
        List<Integer>[] graph = new LinkedList[numCourses];
        
        for(int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        for(int[] pair : preReq) {
            int from = pair[1], to = pair[0];
            graph[from].add(to);
        }
        
        return graph;
    } 
    
    public void traverse(List<Integer>[] graph, int s) {
        // if already on path, find cycle
        if (onPath[s])  hasCycle = true;
        
        // use visited to prevent repeated computation
        if (visited[s] || hasCycle) return;
        
        // preorder
        visited[s] = true;
        onPath[s] = true;
        
        for (int neighbor : graph[s]) {
            traverse(graph, neighbor);
        }
        
        // exit at postorder
        onPath[s] = false;
    }
}