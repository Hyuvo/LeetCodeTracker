// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // bottom up with dp table
        
//         // base case
//         // if (amount == 0) return 0;
//         // if (amount < 0) return -1;
        
//         int[] dp = new int[amount + 1];
//         // the worst case is amount made up of all 1 coins
//         // so amount + 1 is the +infinity here
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for (int i = 0; i < dp.length; ++i) {
//             for (int coin : coins) {
//                 if (i - coin < 0) {
//                     continue;
//                 }
//                 dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//             }
//         }
//         return (dp[amount] == amount + 1) ? -1 : dp[amount];
//     }
// }

class Solution {
    // optimize with memo
    int[] memo;
    
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // init memo with impossible value
        Arrays.fill(memo, -13);
        
        return dp(coins, amount);
    }
    
    public int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        // if in memo
        if (memo[amount] != -13) return memo[amount];
        
        // # of coins
        int num = Integer.MAX_VALUE;
        // try each coin combination
        for (int coin : coins) {
            int subNum = dp(coins, amount - coin);
            // if no solution to sub problem, skip
            if (subNum == -1) continue;
            // maintain min num
            num = Math.min(subNum + 1, num);
        }
        // record the best sol
        memo[amount] = (num == Integer.MAX_VALUE) ? -1 : num;
        return memo[amount];
    }
    
    
}

// class Solution {
//     // brute force top-down
//     public int coinChange(int[] coins, int amount) {
//         // base case
//         if (amount == 0) return 0;
//         if (amount < 0) return -1;
        
//         int result = Integer.MAX_VALUE;
//         // find best sub in coins
//         for (int coin : coins) {
//             int subProblem = coinChange(coins, amount - coin);
//             // if no solution to subproblem, skip it
//             if (subProblem == -1) {
//                 continue;
//             }
//             // choose the smallest # in subproblems
//             result = Math.min(result, subProblem + 1);
//         }
        
//         // in case each sub prob does not work out
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
// }