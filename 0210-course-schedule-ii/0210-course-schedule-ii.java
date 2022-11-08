class Solution {
    // build graph, traverse and add at post-order position
    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle = false;
    List<Integer> postOrder = new ArrayList();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; ++i) {
            traverse(graph, i);
        }
        if (hasCycle) return new int[]{};
        Collections.reverse(postOrder);
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = postOrder.get(i);
        }
        
        return result;
    }
    
    public void traverse(LinkedList<Integer>[] graph, int from) {
        if (onPath[from]) hasCycle = true;
        if (hasCycle || visited[from]) return;
        
        onPath[from] = true;
        visited[from] = true;
        for (int neighbor : graph[from]) {
            traverse(graph, neighbor);
        }
        onPath[from] = false;
        postOrder.add(from);
    }
    
    public LinkedList<Integer>[] buildGraph(int num, int[][] edges) {
        LinkedList<Integer>[] graph = new LinkedList[num];
        for (int i = 0; i < num; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
    
    
}