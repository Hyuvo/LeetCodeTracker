class Solution {
    // build a graph from prerequisites, and check if it has cycle
    boolean hasCycle = false;
    boolean[] visited;
    // track current path
    boolean[] onPath;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // node is 0-indexed
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        LinkedList<Integer>[] graph = buildGraph(prerequisites, numCourses);
        
        // the graph may not be fully connected
        // traverse from each node
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) traverse(graph, i);
        }
        
        // if no cycle exixts, can finish all courses
        return !hasCycle;
    }
    public void traverse(LinkedList<Integer>[] graph, int from) {
        
        if (onPath[from]) hasCycle = true;
        // if found cycle already or visited
        if (hasCycle || visited[from]) return;        
        
        visited[from] = true;
        // traverse thru neighbors
        // pre-order positon: set current node onPath
        onPath[from] = true;
        for (int to : graph[from]) {           
            traverse(graph, to);            
        }
        // post-order: withdraw onPath selection
        onPath[from] = false;
    } 
    
    public LinkedList<Integer>[] buildGraph(int[][] edges, int n) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}