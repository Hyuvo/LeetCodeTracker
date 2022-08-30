class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] profit = new int[n][2];
        for (int i = 0; i < n; ++i) {
            // base case
            if (i - 1 == -1) {
                profit[i][0] = 0;
                profit[i][1] = -prices[i] - fee;
                continue;
            }
            
            // status shift
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            // each transaction start from bought, deduct 1 fee/transaction
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i] - fee);
        }
        return profit[n - 1][0];
    }
}