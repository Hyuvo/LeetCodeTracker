// bottom-up solution
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp[i][j] is the min cost path from (0, 0) to (i, j)
        int[][] dp = new int[m][n];
        // base case
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < n; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }        
        // status shift
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // comes from up or left
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

// top-down solution
// class Solution {
//     int[][] memo;
//     public int minPathSum(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         memo = new int[m][n];
//         // init memo with -1 row by row
//         for (int[] row : memo) {
//             Arrays.fill(row, -1);
//         }
//         // top down solution
//         return dp(grid, m - 1, n - 1);
//     }
    
//     // dp(i, j) is defined as min distance from (0, 0) to (i, j)
//     public int dp(int[][] grid, int i, int j) {
//         // base case
//         if (i == 0 && j == 0) {
//             return grid[0][0];
//         }
//         // if outta boundary
//         if (i < 0 || j < 0) {
//             return Integer.MAX_VALUE;
//         }
//         // look up the memo to reduce duplicate calculation
//         if (memo[i][j] != -1) {
//             return memo[i][j];
//         }
              
//         // from upwards grid or left grid?
//         memo[i][j] = Math.min(dp(grid, i, j - 1), dp(grid, i - 1, j)) + grid[i][j];
//         return memo[i][j];
        
//     }
// }