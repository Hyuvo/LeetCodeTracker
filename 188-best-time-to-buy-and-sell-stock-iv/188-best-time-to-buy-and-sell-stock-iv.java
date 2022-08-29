class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 0) return 0;
        
        if (k > n/2) {
            // at most n/2 transactions take place within n days
            // k > n/2 means not restriction on k
            // use problem 122, max profit w/o k
            return maxProfitWOK(prices);
        }
        // profit[i][k][0/1], at day i, still left k transactions to use, have/not held stock
        int[][][] profit = new int[n][k + 1][2];
        
        // for k == 0
        for (int i = 0; i < n; ++i) {
            profit[i][0][0] = 0;
            profit[i][0][1] = Integer.MIN_VALUE;
                
        }
        
        // start from day1
        for (int i = 0; i < n; ++i) {
            // start from still have 2 transactions
            for (int j = k; j >= 1; --j) {
                // base case
                if (i - 1 == -1) {
                    // profit[-1][k][0] = 0, profit[-1][k][1] = -inf
                    profit[i][j][0] = 0;
                    // profit[-1][k][1] = -inf, profit[-1][k - 1][0] = 0
                    profit[i][j][1] = -prices[i];
                    continue;
                }
                
                // status shift
                profit[i][j][0] = Math.max(profit[i - 1][j][0], profit[i - 1][j][1] + prices[i]);
                profit[i][j][1] = Math.max(profit[i - 1][j][1], profit[i - 1][j - 1][0] - prices[i]);
            }
        }
        return profit[n - 1][k][0];
    }
    
    public int maxProfitWOK(int[] prices) {
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