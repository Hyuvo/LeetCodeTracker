class Solution {
    public int numEnclaves(int[][] grid) {
        // calculate the area of enclosed 1s
        int m = grid.length, n = grid[0].length;

        // first flood islands that are on the border        
        for (int i = 0; i < m; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; ++i) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        
        // count the lefted island(not flood/ not do visited) 
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    // simply count the area
                    count++;
                }
            }
        }
        return count;
    }
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] grid, int i, int j) {
        // termination
        int m = grid.length, n = grid[0].length;
        // off the grid
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // reach the water
        if (grid[i][j] == 0) {
            return;
        }
        // flood the island and its adjacent land
        grid[i][j] = 0;
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
        
    }
}