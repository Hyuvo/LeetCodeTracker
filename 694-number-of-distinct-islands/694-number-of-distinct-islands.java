class Solution {
    public int numDistinctIslands(int[][] grid) {
        // serialize grid, then store in a set and return count
        // for identical island, dfs traverse their grids in the same order
        // represent up, down, left, right with 1, 2, 3, 4, and reverse with minus
        HashSet<String> islands = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    // flood this island
                    dfs(grid, i, j, sb, 33);
                    // serialize the trace to track distinct islands
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();        
    }
    
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        // add string to track trace and dir to track last move direction
        int m = grid.length, n = grid[0].length;
        // termination
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        
        // pre-order position: flood the grid and its adjacent land
        // enter (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');
        
        // traverse up, down, left, right
        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);   
        
        // post-order position: exit (i, j)
        sb.append(-dir).append(',');
            
    }
}