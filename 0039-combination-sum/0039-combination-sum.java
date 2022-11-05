class Solution {
    List<List<Integer>> result = new LinkedList();
    LinkedList<Integer> track = new LinkedList();
    int trackSum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return result;
        backtrack(candidates, 0, target);
        return result;
    }
    
    public void backtrack(int[] candidates, int start, int target) {
        // base case
        if (trackSum == target) {
            result.add(new LinkedList(track));
            return;
        }
        // termination
        if (trackSum > target) return;
        
        for (int i = start; i < candidates.length; ++i) {
            track.add(candidates[i]);
            trackSum += candidates[i];
            // a candidate can be chosen for unlimited times
            // so do not move to the next candidate
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}