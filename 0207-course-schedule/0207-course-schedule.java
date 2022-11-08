class Solution {
    // build graph per prerequisites, and check if has cycle
    private boolean[] onPath;
    private boolean[] visited;
    private boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            traverse(graph, i);
        }
        return !hasCycle;
    }
    
    public void traverse(List<Integer>[] graph, int from) {
        if (onPath[from]) hasCycle = true;
        if (visited[from] || hasCycle) return;
        
        // pre-order
        onPath[from] = true;
        visited[from] = true;
        
        for (int neighbor : graph[from]) {
            traverse(graph, neighbor);
        }
        onPath[from] = false;
    }
    
    private List<Integer>[] buildGraph(int num, int[][] edges) {
        List<Integer>[] graph = new LinkedList[num];
        for (int i = 0; i < num; ++i) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}