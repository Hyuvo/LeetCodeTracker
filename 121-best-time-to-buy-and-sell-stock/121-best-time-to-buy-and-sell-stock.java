class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] profit = new int[n][2];
        for (int i = 0; i < n; ++i) {
            if (i - 1 == -1) {
                // profit[- 1][1][0] = 0, profit[- 1][1][1] = -inf
                profit[i][0] = Math.max(0, Integer.MIN_VALUE);
                // profit[-1][1][1] = -inf, profit[-1][0][0] - prices[0]
                profit[i][1] = Math.max(Integer.MIN_VALUE, -prices[i]);
                continue;
            }                    
            // status shift
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            // profit[i - 1][1][1]  = profit[i - 1][1][1] or profit[i - 1][0][0] - prices[i]
            profit[i][1] = Math.max(profit[i - 1][1], 0 - prices[i]);
        }
        return profit[n - 1][0];
    }
}