class Solution {
    // O(N^2)
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
        // 根据这个定义，我们的最终结果（子序列的最大长度）应该是 dp 数组中的最大值。
        // dp table := dp[i] represents the len of the subseq with nums[i] as its last element
        int[] dp = new int[nums.length];
        // init dp with 1, as the min len of the subseq is it 1(only contains itself)
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            // find ele(j) prior to i than is less than i
            // to satisfy strictly increasing
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxSubLen = 0;
        for (int subLen : dp) {
            maxSubLen = Math.max(maxSubLen, subLen);
        }
        return maxSubLen;
    }
}