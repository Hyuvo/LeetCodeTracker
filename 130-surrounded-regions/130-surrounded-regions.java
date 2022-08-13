class Solution { 
    // union find
    // 'O's on the edges of the board and those adjacent to them are not surrounded 4-directionally
    public void solve(char[][] board) {
        // connect nodes that should not be replaced with dummy
        // then replace those O that are not connected with dummy
        
        // m rows, n columns board
        int m = board.length;
        int n = board[0].length;
        int dummy = m * n;
        
        UnionFind uf = new UnionFind(m * n + 1);
        
        // transform 2d array to 1d: x*n + y
        // union first(y = 0) and last colomn(y = n - 1) "O" to dummy;
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                uf.union(dummy, i * n);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(dummy, i * n + n - 1);
            }
            
        }
        // union first(x = 0) and last row(x = m - 1) 'O' to dummy;
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') {
                uf.union(dummy, j);
            }
            if (board[m - 1][j] == 'O') {
                uf.union(dummy, (m - 1) * n + j);
            }
            
        }
        
        // search within the edges
        // union each 'O' with its adjacent 'O';
        // one step
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (board[i][j] == 'O') {
                    // search 4 directions
                    for (int k = 0; k < 4; ++k) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x *n + y);
                        }
                    }
                }
            }
        }
        
        // replace all 'O's that are not connected with dummy
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    class UnionFind {
        private int count;
        private int[] parent;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        public void union (int u, int v) {
            int uRoot = findRoot(u), vRoot = findRoot(v);
            if (uRoot == vRoot) return;
            
            parent[uRoot] = vRoot;
            count--;
        }
        
        public boolean connected (int u, int v) {
            int uRoot = findRoot(u), vRoot = findRoot(v);
            
            return uRoot == vRoot;
        }
        
        public int findRoot (int x) {
            if (x != parent[x]) {
                parent[x] = findRoot(parent[x]);
            }
            
            return parent[x];
        }
    }
}