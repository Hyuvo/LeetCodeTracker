class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    // to track the path from the root node
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        // use used to avoid duplicate num use
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }
    
    public void backtrack(int[] nums) {
        // base case: reaches the leaf node
        if (path.size() == nums.length) {
            // get 1 possible permutation
            result.add(new LinkedList(path));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            // no duplicate value
            if (used[i]) {
                continue;
            }
            // make a decision
            path.add(nums[i]);
            used[i] = true;
            // traverse to next level
            backtrack(nums);
            // withdraw the decision
            path.removeLast();
            used[i] = false;
        }
    }
}