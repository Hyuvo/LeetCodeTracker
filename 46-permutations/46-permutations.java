class Solution {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        // trace tracks the current path
        LinkedList<Integer> trace = new LinkedList<>();
        // used[i] == true means nums[i] is already on current path
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, trace, used);
        return result;
    }
    
    public void backtrack(int[] nums, LinkedList<Integer> trace, boolean[] used) {
        // terminate condition
        if (trace.size() == nums.length) {
            // complete one possibility
            // new to new a linkedlist object
            result.add(new LinkedList<>(trace));
        }
        
        // traverse children
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            // make choice
            trace.add(nums[i]);
            used[i] = true;
            // recurse
            backtrack(nums, trace, used);
            // cancel choice
            trace.removeLast();
            used[i] = false;
        }
    }
}