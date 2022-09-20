class Solution {
    private int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j] = the min sum of falling path to (i, j)
        memo = new int[m][n];
        // init memo with 10001, as -10000 <= result <= 10000
        for (int[] row : memo) {
            Arrays.fill(row, 10001);
        }
        
        int result = 10001;
        // the result is the min of the last row of the dp memo
        for (int i = 0; i < n; i++) {
            result = Math.min(dp(matrix, m - 1, i), result);
        }
        return result;        
    }
    
    public int dp(int[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        // outta bound
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 10001;
        }
        // base case: the first row
        if (i == 0) {
            return matrix[0][j];
        }
        // look up the memo
        if (memo[i][j] != 10001) {
            return memo[i][j];
        }        
        // status shift
        // falls from up-left, up, up-right
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1),
                                        dp(matrix, i - 1, j),
                                        dp(matrix, i - 1, j + 1));
       
        return memo[i][j];        
    }
    
    public int min(int a, int b, int c) {
        int result = Math.min(a, b);
        result = Math.min(result, c);
        return result;
    }
}