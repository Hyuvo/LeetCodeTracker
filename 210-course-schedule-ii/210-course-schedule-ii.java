class Solution {
//     // topological sorting DFS
//     private boolean[] visited, onPath;
//     private boolean hasCycle;
//     // use array list to access with time O(1)
//     private List<Integer> postorder = new ArrayList<>();
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
//         // traverse to see if it has cycle and get postorder
//         hasCycle = false;
//         visited = new boolean[numCourses];
//         onPath = new boolean[numCourses];
        
//         // courses may not be connected altogether, need start from each node
//         for (int i = 0; i < numCourses; ++i) {
//             traverse(graph, 0);
//         }     
//         // if has cycle, it is impossible to finish all courses
//         // return an empty array
//         if (hasCycle) {
//             return new int[]{};
//         }
        
//         // reverse the postorder to get the topological sorted result
//         Collections.reverse(postorder);
//         int[] result = new int[numCourses];
//         for (int i = 0; i < numCourses; ++i) {
//             result[i] = postorder.get(i);
//         }
        
//         return result;
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
    List<Integer> postorder = new ArrayList<>();
    // 记录是否存在环
    boolean hasCycle = false;
    boolean[] visited, onPath;

    // 主函数
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        // 遍历图
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        // 有环图无法进行拓扑排序
        if (hasCycle) {
            return new int[]{};
        }
        // 逆后序遍历结果即为拓扑排序结果
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    // 图遍历函数
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 发现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }
        // 前序遍历位置
        onPath[s] = true;
        visited[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历位置
        postorder.add(s);
        onPath[s] = false;
    }

    // 建图函数
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
    // 图中共有 numCourses 个节点
    List<Integer>[] graph = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; i++) {
        graph[i] = new LinkedList<>();
    }
    for (int[] edge : prerequisites) {
        int from = edge[1], to = edge[0];
        // 添加一条从 from 指向 to 的有向边
        // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
        graph[from].add(to);
    }
    return graph;
}
}