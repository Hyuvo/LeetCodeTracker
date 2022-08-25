class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // the value can be put after slow
                // slow++;
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        // the first k elements of nums should hold the final result.
        // 0-indexed
        return slow + 1;
    }
}