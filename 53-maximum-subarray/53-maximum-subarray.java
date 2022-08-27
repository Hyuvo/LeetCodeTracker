class Solution {
    // time: O(N), space O(1)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        // dp is the max sum of contiguous subarray prior to index i (inclusive)
        // base case
        int dp_0 = nums[0], dp_1 = 0;
        int result = dp_0;
        for (int i = 1; i < n; ++i) {
            // update on a rolling basis
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            result = Math.max(result, dp_1);
            dp_0 = dp_1;
        }
        return result;
    }
}

// class Solution {
//     // time: O(N), space: O(N)
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         // dp[i] is the max sum of contiguous subarray prior to index i(incluseve)
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         for (int i = 1; i < n; ++i) {
//             // the max sum of i is either the i - 1's max sum or make i contiguous to previous subarray
//             //// 要么自成一派，要么和前面的子数组合并
//             dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//         }
        
//         int result = Integer.MIN_VALUE;
//         for (int i = 0; i < n; ++i) {
//             result = Math.max(result, dp[i]);
//         }
//         return result;
//     }
// }