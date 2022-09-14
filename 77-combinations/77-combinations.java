class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    // to track the path from the root node
    private LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return result;
    }
    
    private void backtrack(int n, int start, int k) {
        // only collect nodes on the kth level(0-indexed) at pre-order
        if (k == path.size()) {
            result.add(new LinkedList<>(path));
        }
        
        
        for (int i = start; i <= n; ++i) {
            // make a decision
            path.add(i);
            // traversal
            backtrack(n, i + 1, k);
            // withdraw the decision
            path.removeLast();
        }
    }
}