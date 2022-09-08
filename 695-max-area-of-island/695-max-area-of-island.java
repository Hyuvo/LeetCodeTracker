class Solution {
    // calculate the max area
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));            
            }
        }
        return maxArea;
    }
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int dfs(int[][] grid, int i, int j) {
        // count the area while flooding the island
        int m = grid.length, n = grid[0].length;
        // termination
        // outta bound
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        // already water
        if (grid[i][j] == 0) return 0;
        
        // flood the island and its adjacent land
        grid[i][j] = 0;
        // track the area along the way
        int area = 1;
        for (int[] dir : directions) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}