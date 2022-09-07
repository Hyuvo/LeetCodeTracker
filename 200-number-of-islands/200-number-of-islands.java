class Solution {
    // count # of islands
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    // once find an island, count
                    count++;
                    // and flood its ajacent land
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // termination
        // outta boundary
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // water or already flooded
        if (grid[i][j] == '0') {
            return;
        }
        // flood this grid
        grid[i][j] = '0';
        // flood its ajacent land
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }        
    }
}