class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }
    
    public void backtrack(int[] nums, int start) {
        // collect node at pre-order position
        result.add(new LinkedList(track));
        
        for (int i = start; i < nums.length; ++i) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}