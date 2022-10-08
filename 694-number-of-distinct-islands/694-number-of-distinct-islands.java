class Solution {
    // identical islands are traversed by dfs with the same order
    // serialize the trace of dfs and store it in the set to get distinct trace
    HashSet<String> islands = new HashSet();
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    // start with a unique dir
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 13);
                    // don't forget to add the traversal result!!!!
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    
    // represent moving up, down, left, right with 1, 2, 3, 4, and reversely with -dir
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        // check boundary
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 0) return;
        
        // pre-order position: flood current grid
        // enter (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');
        
        // traverse its adjacent lands and track the trace
        dfs(grid, i, j - 1, sb, 1);
        dfs(grid, i, j + 1, sb, 2);
        dfs(grid, i - 1, j, sb, 3);
        dfs(grid, i + 1, j, sb, 4);
        
        // post-order position: exit (i, j)
        sb.append(-dir).append(',');
    }
}