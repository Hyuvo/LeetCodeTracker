class Solution {
    List<List<Integer>> result = new LinkedList<>();
    // track path (from the root node)
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(nums, 0);
        return result;
        
    }
    
    private void backtrack(int[] nums, int start) {
        
        // pre-order position, the val of each node is a subset
        result.add(new LinkedList<>(path));
        
        for (int i = start; i < nums.length; ++i) {
            // make choice
            path.add(nums[i]);
            // traversal to the next num
            // using start to avoid duplicate combinations
            backtrack(nums, i + 1);
            // withdraw decision
            path.removeLast();
        }
    }
}