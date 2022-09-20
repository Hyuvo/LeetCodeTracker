class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        // init memo with -1 row by row
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // top down solution
        return dp(grid, m - 1, n - 1);
    }
    
    // dp(i, j) is defined as min distance from (0, 0) to (i, j)
    public int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // if outta boundary
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // look up the memo to reduce duplicate calculation
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
              
        // from upwards grid or left grid?
        memo[i][j] = Math.min(dp(grid, i, j - 1), dp(grid, i - 1, j)) + grid[i][j];
        return memo[i][j];
        
    }
}