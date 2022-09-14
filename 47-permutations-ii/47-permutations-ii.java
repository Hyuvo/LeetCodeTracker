class Solution {
    // need to cancel order within duplicates(bind in-group order)
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        // first sort nums to gather duplicates
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }
    
    private void backtrack(int[] nums) {
        // base case
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) continue;
            
            // cut branches
            // set the relative order of duplicates
            if (i > 0 && (nums[i] == nums[i - 1]) && !used[i - 1]) {
                continue;
            }
            
            // make a decision
            track.add(nums[i]);
            used[i] = true;
            // traverse
            backtrack(nums);
            // withdraw the decision
            track.removeLast();
            used[i] = false;
        }
    }
}