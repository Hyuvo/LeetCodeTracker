class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<Integer>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return result;
        backtrack(candidates, 0, target);
        return result;
    }
    
    private void backtrack(int[] nums, int start, int target) {
        // base case
        if (trackSum == target) {
            result.add(new LinkedList(track));
            return;
        }
        // exceed
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            // make a decision
            track.add(nums[i]);
            trackSum += nums[i];
            // as a candidate can be used multiple times
            backtrack(nums, i, target);
            // withdraw the decision
            track.removeLast();
            trackSum -= nums[i];
            
        }
        
    }
}