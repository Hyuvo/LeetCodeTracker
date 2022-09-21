class Solution {
    // DFS topo sort
    boolean hasCycle = false;
    boolean[] visited;
    boolean[] onPath;
    List<Integer> postOrder = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        LinkedList<Integer>[] graph = buildGraph(prerequisites, numCourses);
        
        // the graph may not be fully connected
        // traverse from each node
        for (int i = 0; i < numCourses; ++i) {
            traverse(graph, i);
        }
        // if the graph has cycle, cannot finish all courses
        if (hasCycle) return new int[]{};
        // if can finish all courses
        // the result is the reverse of the post-order
        Collections.reverse(postOrder);
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            result[i] = postOrder.get(i);
        }
        return result;
    }
    
    // DFS
    public void traverse(LinkedList<Integer>[] graph, int from) {
        // if already on current trace
        if (onPath[from]) hasCycle = true;
        // if already has cycle or visited
        if (hasCycle || visited[from]) return;
        
        // pre-order position
        visited[from] = true;
        onPath[from] = true;
        // traversal
        for (int to : graph[from]) {
            traverse(graph, to);
        }
        // post-order position: withdraw selection and track order
        // the most upstream course is at top of the stack
        onPath[from] = false;
        postOrder.add(from);
               
    }
    
    public LinkedList<Integer>[] buildGraph(int[][] edges, int n) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        // node is 0-indexed
        for (int i = 0; i < n; ++i) {
            graph[i] = new LinkedList();
        }
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        
        return graph;
    }
}


// class Solution {   
//     // topological sorting by BFS
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         // build graph first
//         List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
//         // track indegree for each course
//         int[] indegrees = new int[numCourses];
//         for (int[] pair : prerequisites) {
//             // count to for indegree
//             int from = pair[1], to = pair[0];
//             indegrees[to]++;
//         }
        
//         // init queue for BFS
//         Queue<Integer> q = new LinkedList<>();
        
//         // put all 0-indegree course in the queue
//         for (int i = 0; i < numCourses; ++i) {
//             if (indegrees[i] == 0) {
//                 q.offer(i);
//             }
//         }
//         int[] result = new int[numCourses];
//         // count is the index of the order, the # of how many courses can be taken
//         int count = 0;
//         while(!q.isEmpty()) {
//             int current = q.poll();
//             // the inorder is the topological sorting result     
//             // counting the # of courses whose indegree can be 0
//             result[count++] = current;
//             // deduct 1 from its neighbors' indegrees
//             for (int neighbor : graph[current]) {
//                 indegrees[neighbor]--;
//                 if (indegrees[neighbor] == 0) {
//                     q.offer(neighbor);
//                 }
//             }
//         }
        
//         return count == numCourses ? result : new int[]{};
//     }
    
//     public List<Integer>[] buildGraph(int numCourses, int[][] preReq) {
//         List<Integer>[] graph = new LinkedList[numCourses];
        
//         for (int i = 0; i < numCourses; ++i) {
//             graph[i] = new LinkedList<>();
//         }
//         for (int[] pair : preReq) {
//             int from = pair[1], to = pair[0];
//             graph[from].add(to);
//         }
        
//         return graph;
//     }
// }

// class Solution {
//     // topological sorting by DFS
//     boolean[] visited, onPath;
//     boolean hasCycle = false;
//     // use array list to access with time O(1)
//     List<Integer> postorder = new ArrayList<>();
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
//         // traverse to see if it has cycle and get postorder
//         visited = new boolean[numCourses];
//         onPath = new boolean[numCourses];
    
//         // courses may not be connected altogether, need start from each node
//         for (int i = 0; i < numCourses; ++i) {
//             traverse(graph, i);
//         }     
//         // if has cycle, it is impossible to finish all courses
//         // return an empty array
//         if (hasCycle) {
//             return new int[]{};
//         } else {
//             // reverse the postorder to get the topological sorted result
//             Collections.reverse(postorder);
//             int[] result = new int[numCourses];
//             for (int i = 0; i < numCourses; ++i) {
//                 result[i] = postorder.get(i);
//             }

//             return result;
//         }
        
        
//     }
    
//     public List<Integer>[] buildGraph(int numCourses, int[][] preReq) {
//         List<Integer>[] graph = new LinkedList[numCourses];
//         for (int i = 0; i < numCourses; ++i) {
//             graph[i] = new LinkedList<>();
//         }
        
//         for (int[] pair : preReq) {
//             // from prerequisite to course to take
//             int from = pair[1], to = pair[0];
//             graph[from].add(to);
//         }
        
//         return graph;
        
//     }
    
//     public void traverse(List<Integer>[] graph, int s) {
//         if (onPath[s]) hasCycle = true;
        
//         if (visited[s] || hasCycle) return;
        
//         visited[s] = true;
//         onPath[s] = true;
//         for (int neighbor : graph[s]) {
//             traverse(graph, neighbor);
//         }
        
//         postorder.add(s);
//         onPath[s] = false;
//     }
    
// }
