class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    // track the path from root node
    private LinkedList<Integer> track = new LinkedList<>();
    // track the sum of current path
    private int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // candidates contains duplicates
        // find subsets whose sum = target
        if (candidates.length == 0) return result;
        // first sort the candidates to gather duplicates, avoiding duplicate combinations
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return result;
    }
    
    private void backtrack(int[] nums, int start, int target) {
        // base case
        if (trackSum == target) {
            result.add(new LinkedList(track));
        }
        
        // if exceeds, skip this num
        if (trackSum > target) {
            return;
        }
        // use start to avoid going back
        for (int i = start; i < nums.length; ++i) {
            // if used a duplicate in the current combination
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // make a decision
            track.add(nums[i]);
            trackSum += nums[i];
            // traverse
            backtrack(nums, i + 1, target);
            // withdraw the decision
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}