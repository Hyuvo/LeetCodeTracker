class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp_0 = nums[0];
        // base case, if n == 1
        int result = dp_0;
        for (int i = 1; i < n; ++i) {
            // dp_i is the largest sub-sum before nums[i] (inclusive)
            // dp_i is either first i-1 add nums[i] or nums[i] itself
            int dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            result = Math.max(result, dp_1);
            dp_0 = dp_1;
        }
        return result;        
    }
}

// bottom-up with dp table, with O(n) time, O(n) space
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         for (int i = 1; i < n; ++i) {
//             // either adjacent to i-1 or nums[i] itself
//             dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//         }
//         // return the max
//         int result = Integer.MIN_VALUE;
//         for (int i = 0; i < n; ++i) {
//             result = Math.max(result, dp[i]);
//         }
//         return result;
//     }
// }