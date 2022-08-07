class Solution {
    // topological sorting DFS
    boolean[] visited, onPath;
    boolean hasCycle = false;
    // use array list to access with time O(1)
    List<Integer> postorder = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        // traverse to see if it has cycle and get postorder
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
    
        // courses may not be connected altogether, need start from each node
        for (int i = 0; i < numCourses; ++i) {
            traverse(graph, i);
        }     
        // if has cycle, it is impossible to finish all courses
        // return an empty array
        if (hasCycle) {
            return new int[]{};
        } else {
            // reverse the postorder to get the topological sorted result
            Collections.reverse(postorder);
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                result[i] = postorder.get(i);
            }

            return result;
        }
        
        
    }
    
    public List<Integer>[] buildGraph(int numCourses, int[][] preReq) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        for (int[] pair : preReq) {
            // from prerequisite to course to take
            int from = pair[1], to = pair[0];
            graph[from].add(to);
        }
        
        return graph;
        
    }
    
    public void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) hasCycle = true;
        
        if (visited[s] || hasCycle) return;
        
        visited[s] = true;
        onPath[s] = true;
        for (int neighbor : graph[s]) {
            traverse(graph, neighbor);
        }
        
        postorder.add(s);
        onPath[s] = false;
    }
    
}