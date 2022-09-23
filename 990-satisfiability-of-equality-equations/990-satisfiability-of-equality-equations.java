class Solution {
    // union find
    public boolean equationsPossible(String[] equations) {
        // vars are lowercase letters
        UnionFind uf = new UnionFind(26);
        // first connect all "=="
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0), y = equation.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        // then go thru all "!=" to check if they are connected
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0), y = equation.charAt(3);
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
            this.count = n;
            parent = new int[n];
            // init each node's parent to itself
            for (int node = 0; node < n; ++node) {
                parent[node] = node;
            }
        }
               
        // find the root of node x and return
        public int find(int x) {
            // if x is not root
            // recursively find and connect node alongside to the 1 very root
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        // see if 2 nodes are in the same union
        public boolean isConnected(int a, int b) {
            int rootA = find(a), rootB = find(b);
            return rootA == rootB;
        }
        
        // union 2 nodes
        public void union(int a, int b) {
            int rootA = find(a), rootB = find(b);
            // if already united
            if (rootA == rootB) return;
            
            // point a's root to b's root
            parent[rootA] = rootB;
        }
        
        public int count() {
            return this.count;
        }
    }
}