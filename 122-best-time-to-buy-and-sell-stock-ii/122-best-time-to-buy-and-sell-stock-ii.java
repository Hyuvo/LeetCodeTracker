class Solution {
    public int maxProfit(int[] prices) {
        // As only a share of stock can be held at a time, buy and sell at the same day does not make sense
        // trade# limit k = +inf
        int n = prices.length;
        int[][] profit = new int[n][2];
        
        for (int i = 0; i < n; ++i) {
            //base case
            if (i - 1 == -1) {
                // profit[-1][inf][1] = -inf, profit[-1][inf][0] = 0
                profit[i][1] = -prices[i];
                // profit[-1][inf][0] = 0, profit[-1][inf][1] = -inf
                profit[i][0] = 0;
                continue;
            }
            // status shift
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
        }
        return profit[n - 1][0];
    }
}