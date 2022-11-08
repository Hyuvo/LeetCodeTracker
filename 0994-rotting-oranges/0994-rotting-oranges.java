class Solution {
    // bfs
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque();
        int fresh = 0;
        // add initial rotten orages to the q as the first level
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) 
                    q.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
              
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int time = 0;
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {            
                int[] curr = q.poll();
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    // find a fresh orange, rot it
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        q.offer(new int[]{x, y});
                        grid[x][y] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }        
        return fresh == 0 ? time : -1;
    }
}