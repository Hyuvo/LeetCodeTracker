class Solution {
    boolean[] visited;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> mht = new ArrayList<Integer>();
        if (n == 1) {
            mht.add(0);
            return mht;
        }
        // build graph, using adjacent list
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            // node x, y on edge
            int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        // init degree for each node
        int[] degree = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque();
        
        for (int i = 0; i < n; ++i) {
            degree[i] = graph[i].size();
            // add most outter node to the q
            if (degree[i] == 1) 
                q.offer(i);
        }
        // topo sort by bfs
        // peel the nodes layer by layer
        int remain = n;
        // the centroids for a tree-like graph is no more than 2
        while (remain > 2) {
            // get size of current layer
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int curr = q.poll();
                for (int neighbor : graph[curr]) {
                    // why check?
                    // if (degree[neighbor] == 1) 
                    //     continue;
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) 
                        q.offer(neighbor);
                }
            }
            remain -= size;
        }
        // only centroids left in the q
        
        while (!q.isEmpty()) {
            int center = q.poll();
            mht.add(center);
        }
        return mht;
    }
}