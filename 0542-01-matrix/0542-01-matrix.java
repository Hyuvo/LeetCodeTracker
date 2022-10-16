class Solution {
    // BFS
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque();
        boolean[][] visited = new boolean[m][n];
        // add all 0s to q and visited
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        //BFS
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] current = q.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    // not visited yet and non-0
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        mat[x][y] = step;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }        
        return mat;
    }
}