class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, path, 0);
        return result;
    }
    
    public void traverse(int[][] graph, LinkedList<Integer> path, int current) {
        // traverse from current to n - 1
        // track current path
        path.addLast(current);
        int n = graph.length;
        // if reaches the target
        if (current == n - 1) {
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        // traverse through neighbors
        for (int neighbor : graph[current]) {
            traverse(graph, path, neighbor);
        }
        
        // withdraw current from path
        path.removeLast();
    } 
}