class Solution {    
    private List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // maintain current path
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return result;
    }
    
    public void traverse(int[][] graph, int current, LinkedList<Integer> path) {
        // traverse from current, record paths that go to n-1
        
        // add current node
        path.add(current);
        int n = graph.length;
        // if reaches the target, put the current path in the result
        if (current == n - 1) {
            // why new list?
            result.add(new LinkedList(path));
            // exit the node
            path.removeLast();
            return;
        }
        
        // if not reaches the end, explore its neighbors
        for (int neighbor : graph[current]) {
            traverse(graph, neighbor, path);
        }
        // exit current node;
        path.removeLast();
        
    }
}