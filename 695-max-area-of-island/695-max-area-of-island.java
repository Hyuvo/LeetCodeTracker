class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max_area = 0;
        // maintain max_area while traversing
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max_area = Math.max(max_area, dfs(grid, i, j));
            }
        }
        return max_area;
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // dfs return flooded area
    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // validate (i, j)
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        
        // flood and add up area
        // start from current cell with area = 1
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : directions) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}