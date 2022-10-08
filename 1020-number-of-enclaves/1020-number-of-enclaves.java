class Solution {
    // # of land cells
    // do not count boundaries
    // calculate the area of enclosed 1s
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // flood 4 borders
        for (int i = 0; i < m; ++i) {
            // flood 1st col and last col
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            // flood 1st row and last row
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        
        // count lefted land cells
        int num = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++num;
                }
            }
        }
        return num;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // validate (i, j)
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // if is water, skip
        if (grid[i][j] == 0) {
            return;
        }
        
        // flood current land
        grid[i][j] = 0;
        // go to its adjacent lands
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
        
}