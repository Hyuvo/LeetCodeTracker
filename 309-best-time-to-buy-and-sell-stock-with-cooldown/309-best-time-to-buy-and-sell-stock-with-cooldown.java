class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // no restriction on transactions, no k
        
        int[][] profit = new int[n][2];
        
        // status shift
        for (int i = 0; i < n; ++i) {
            //base case
            if (i - 1 == -1) {
                profit[i][0] = 0;
                profit[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
                profit[i][1] = Math.max(profit[i - 1][1], - prices[i]);
                continue;
            }
            
            // no restriction on selling
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            // cannnot buy if sold yesterday(sold the day before yesterday)
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 2][0] - prices[i]);
                
        }
        return profit[n - 1][0];
    }
}