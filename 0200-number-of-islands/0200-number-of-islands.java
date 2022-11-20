class Solution {
    // flood fill
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 有1吗？
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >=m || j < 0 || j >= n) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(grid, x, y);
        }        
    }
}