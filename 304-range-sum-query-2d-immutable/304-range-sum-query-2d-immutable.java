class NumMatrix {
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        preSum = new int[m + 1][n + 1];        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //preSum[i][j] is the sum of all nums within (0, 0) and (i - 1, j - 1)
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i- 1][j - 1] - preSum[i - 1][j - 1];
                // count preSum[i - 1][j - 1] twice
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // just draw it...
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */