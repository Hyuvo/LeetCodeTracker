class Solution {
    public int coinChange(int[] coins, int amount) {
        // bottom up with dp table
        
        // base case
        // if (amount == 0) return 0;
        // if (amount < 0) return -1;
        
        int[] dp = new int[amount + 1];
        // the worst case is amount made up of all 1 coins
        // so amount + 1 is the +infinity here
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; ++i) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}

// class Solution {
//     // optimize with memo
//     private int[] memo;
    
//     public int coinChange(int[] coins, int amount) {
//         memo = new int[amount + 1];
//         Arrays.fill(memo, -111);
//         return dynamic(coins, amount);
//     }
    
//     private int dynamic(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         if (amount < 0) return -1;
//         // if knows the result, no need to recalculate
//         if (memo[amount] != -111) {
//             return memo[amount];
//         }
        
//         int result = Integer.MAX_VALUE;
//         for (int coin : coins) {
//             // subproblem is the # of coins
//             int subProblem = dynamic(coins, amount - coin);
//             if (subProblem == -1) {
//                 continue;
//             }
//             result = Math.min(result, subProblem + 1);
//         }
//         // also store -1 when there's no solution
//         memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
//         return memo[amount];
//     }
// }

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