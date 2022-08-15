class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    class State {
        int x, y;
        // effort from start
        int effort;
        
        public State(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }        
    }
    
    public int minimumEffortPath(int[][] heights) {
        // Note: effort is the maximum absolute difference in heights between two consecutive cells of the route. index start from 0
        // Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
        int m = heights.length, n = heights[0].length;
        
        // the effort from (0, 0) to (i, j) is effort[i][j]
        int[][] effortTo = new int[m][n];  
        for (int i = 0; i < m; ++i) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;
        
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effort - b.effort;
        });
        
        pq.add(new State(0, 0, 0));
        
        while(!pq.isEmpty()) {
            State current = pq.remove();
            int curX = current.x;
            int curY = current.y;
            int curEffort = current.effort;
            
            // if reach the target
            if (curX == m - 1 && curY == n - 1) {
                return curEffort;
            }
            
            // if no better than current least effort
            if (curEffort > effortTo[curX][curY]) {
                continue;
            }
            
            List<int[]> neighbors = buildAdj(heights, curX, curY);
            for (int[] neighbor : neighbors) {
                int nextX = neighbor[0], nextY = neighbor[1];
                // effort from start to the next
                int effortToNext = Math.max(curEffort, Math.abs(heights[nextX][nextY] - heights[curX][curY]));
                // Return the minimum effort 
                if (effortTo[nextX][nextY] > effortToNext) {
                    effortTo[nextX][nextY] = effortToNext;
                    pq.add(new State(nextX, nextY, effortToNext));
                }
            }
        }
        
        return -1;
        
    }
    
    public List<int[]> buildAdj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            // stay in boundary
            if (newX >= m || newY >= n || newX < 0 || newY < 0)
                continue;
            neighbors.add(new int[]{newX, newY});
        }
        
        return neighbors;
        
    }
}