class Solution {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // when a land in grid2 is a grid of water in grid1, then it's not a sub-island
        int m = grid1.length, n = grid1[0].length;        
        // exclude all non-sub-islands first
        for (int i = 0; i < m ; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    // flood it!
                    dfs(grid2, i, j);
                }
            }
        }
        // count survived sub-island
        int count = 0;
        for (int i = 0; i < m ; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1) {
                    // flood it!
                    ++count;
                    dfs(grid2, i, j);
                }
            }
        }
        return count;
    }
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // termination
        // outta bound
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        // it's water
        if (grid[i][j] == 0) return;
        
        // flood the island and its adjacent land
        grid[i][j] = 0;
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}