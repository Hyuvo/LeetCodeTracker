class Solution {
    // flood fill
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    // count # of islands
                    ++num;
                    // flood the land
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // outta bound
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // skip waters
        if (grid[i][j] == '0') {
            return;
        }
        // flood current land
        grid[i][j] = '0';
        // flood adjacent lands
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}