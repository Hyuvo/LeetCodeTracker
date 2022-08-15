class Solution {
    
    class State {
        int x, y;
        int effort;
        
        public State(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        // Dijsktra
        // Note: effort is the maximum absolute difference in heights between two consecutive cells of the route.
        // Return the minimum effort
        // 0-indexed
        
        // the effort from (0, 0) to (i, j) is effortTo[i][j]
        int m = heights.length, n = heights[0].length;
        int[][] effortTo = new int[m][n];
        
        // init with infinity
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;
        
        // min queue
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effort - b.effort;
        });
        pq.add(new State(0, 0, 0));
        
        //BFS
        while(!pq.isEmpty()) {
            State current = pq.remove();
            int curX = current.x, curY = current.y;
            int curEffort = current.effort;
            
            // if reach the target
            if (curX == m - 1 && curY == n - 1) {
                return curEffort;
            }
            
            // if no better than previous effort
            if (curEffort > effortTo[curX][curY]) {
                continue;
            }
            
            // broadcast to neighbors
            List<int[]> neighbors = getNeighbors(heights, curX, curY);
            for (int[] neighbor : neighbors) {
                int nextX = neighbor[0], nextY = neighbor[1];
                // effort to next is either the current effort, or the |difference(cur, next)|
                int effortToNext = Math.max(curEffort, Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                
                // update the queue (shorter route)
                if (effortTo[nextX][nextY] > effortToNext) {
                    effortTo[nextX][nextY] = effortToNext;
                    pq.add(new State(nextX, nextY, effortToNext));
                }
            }
        }
        
        return -1;                
        
    }
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};       public List<int[]> getNeighbors(int[][] matrix, int x, int y) {
        List<int[]> neighbors = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < 4; ++i) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        
        return neighbors;
    }
}