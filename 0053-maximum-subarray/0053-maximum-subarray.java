class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            // either adjacent to i-1 or nums[i] itself
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        // return the max
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}