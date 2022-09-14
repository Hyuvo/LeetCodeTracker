class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // first sort to let duplicates gather
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }
    
    // use start to avoid going back
    private void backtrack(int[] nums, int start) {
        // each node is a possible subset
        result.add(new LinkedList(track));
        
        for (int i = start; i < nums.length; ++i) {
            // if duplicates, only count combination once
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // make a decision
            track.add(nums[i]);
            // go to next num
            backtrack(nums, i + 1);
            // withdraw the decision
            track.removeLast();
        }
    }
}