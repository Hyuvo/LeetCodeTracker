class Solution {
    // reverse graph and count how many node's indgree can be deduct to 0
    // count how many courses can possibly be finished
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // reversed graph
        LinkedList<Integer>[] rg = new LinkedList[n];
        // open space
        for (int i = 0; i < n; ++i) {
            rg[i] = new LinkedList();
        }
        // fill rg and init indegree
        int[] indegree = new int[n];
        for (int from = 0; from < n; ++from) {
            for (int to : graph[from]) {
                // reverse the edge
                rg[to].add(from);
            }
            // the original outdgree is the indegree of the reversed graph
            indegree[from] = graph[from].length;
        }
        // topological sorting with BFS
        Queue<Integer> q = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        // init q with 0-indegree nodes
        for (int node = 0; node < n; ++node) {
            if (indegree[node] == 0) {
                q.offer(node);
                result.add(node);
            }
        }
        
        while (!q.isEmpty()) {
            int current = q.poll();
            // to is the downstream neighbor of current
            for (int to : rg[current]) {
                // deduct 1 for each down neighbor
                // if indegree == 0
                if (--indegree[to] == 0) {
                    // enque and collect result
                    q.offer(to);
                    result.add(to);
                }
            }
        }
        Collections.sort(result);
        return result;        
    }
}