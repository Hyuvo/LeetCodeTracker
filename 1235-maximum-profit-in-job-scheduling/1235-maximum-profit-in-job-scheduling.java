class Solution {
    // return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // sort by end time
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        // dp[i] is the possible maximam profit of first ith jobs
        int[] dp = new int[n + 1];
        // no profit if did 0 job
        dp[0] = 0;
        // for ith job, the max profit could be not do i, or do i
        // if not do ith job, dp[i - 1]
        // dp is 1-indexed, profit is 0-indexed
        // if do i, for i alone, profit[i - 1], max profit before i is dp[i - 1]
        // dp[i] = max(dp[i - 1], dp[k] + profit[i - 1])
        // k needs to end no later than i - 1 starts
        for (int i = 1; i <= n; ++i) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], jobs[i - 1][2] + dp[k]);
        }
        return dp[n];
    }
    
    // search left bound
    public int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // ends no later than target
            if (jobs[mid][1] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
}