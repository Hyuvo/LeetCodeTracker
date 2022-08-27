class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // profit[i][k][0/1], at day i, still left k transactions to use, have/not held stock
        int max_k = 2;
        int[][][] profit = new int[n][max_k + 1][2];
        
        // start from day1
        for (int i = 0; i < n; ++i) {
            // start from still have 2 transactions
            for (int k = max_k; k >= 1; --k) {
                // base case
                if (i - 1 == -1) {
                    // profit[-1][k][0] = 0, profit[-1][k][1] = -inf
                    profit[i][k][0] = 0;
                    // profit[-1][k][1] = -inf, profit[-1][k - 1][0] = 0
                    profit[i][k][1] = -prices[i];
                    continue;
                }
                
                // status shift
                profit[i][k][0] = Math.max(profit[i - 1][k][0], profit[i - 1][k][1] + prices[i]);
                profit[i][k][1] = Math.max(profit[i - 1][k][1], profit[i - 1][k - 1][0] - prices[i]);
            }
        }
        return profit[n - 1][max_k][0];
    }
}