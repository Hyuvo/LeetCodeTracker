class Solution {
    public int closedIsland(int[][] grid) {
        // flood every island on the borders
        int m = grid.length, n = grid[0].length;
        // left and right borders
        for (int i = 0; i < m; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);            
        }
        
        // upper and lower borders
        for (int j = 0; j < n; ++j) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0){
                    count++;
                    dfs(grid, i, j);
                }                    
            }
        }
        return count;
    }
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void dfs(int[][] grid, int i, int j) {
        // termination
        int m = grid.length, n = grid[0].length;
        // outta bound
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // is not island (not 0)
        if (grid[i][j] == 1) {
            return;
        }        
        // flood this island and its adjacent land
        grid[i][j] = 1;
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}