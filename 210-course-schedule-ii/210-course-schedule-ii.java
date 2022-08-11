class Solution {   
    // topological sorting by BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph first
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        // track indegree for each course
        int[] indegrees = new int[numCourses];
        for (int[] pair : prerequisites) {
            // count to for indegree
            int from = pair[1], to = pair[0];
            indegrees[to]++;
        }
        
        // init queue for BFS
        Queue<Integer> q = new LinkedList<>();
        
        // put all 0-indegree course in the queue
        for (int i = 0; i < numCourses; ++i) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int[] result = new int[numCourses];
        // count is the index of the order, the # of how many courses can be taken
        int count = 0;
        while(!q.isEmpty()) {
            int current = q.poll();
            // the inorder is the topological sorting result          
            result[count++] = current;
            // deduct 1 from its neighbors' indegrees
            for (int neighbor : graph[current]) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        
        return count == numCourses ? result : new int[]{};
    }
    
    public List<Integer>[] buildGraph(int numCourses, int[][] preReq) {
        List<Integer>[] graph = new LinkedList[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pair : preReq) {
            int from = pair[1], to = pair[0];
            graph[from].add(to);
        }
        
        return graph;
    }
}

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


