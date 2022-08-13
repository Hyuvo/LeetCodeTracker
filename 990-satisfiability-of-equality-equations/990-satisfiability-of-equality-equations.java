class Solution {
    public boolean equationsPossible(String[] equations) {
        // first union all equal variables
        UnionFind uf = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        // then see if unequal variables are connected on the uf
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                // if connected, loical confilit exists
                if (uf.isConnected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        
        return true;
              
    }
    
    class UnionFind {
        private int count;
        private int[] parent;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            // point to itself at init
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        public void union(int u, int v) {
            int uRoot = findRoot(u), vRoot = findRoot(v);
            if (uRoot == vRoot) {
                return;
            } 
            
            parent[uRoot] = vRoot;
            count--;                            
        }
        
        public boolean isConnected(int u, int v) {
            int uRoot = findRoot(u), vRoot = findRoot(v);
            
            return uRoot == vRoot;
        }
        
        public int findRoot(int x) {
            if (parent[x] != x) {
                parent[x] = findRoot(parent[x]);
            }
            return parent[x];
        }
        
        public int count() {
            return count;
        }
    }
}