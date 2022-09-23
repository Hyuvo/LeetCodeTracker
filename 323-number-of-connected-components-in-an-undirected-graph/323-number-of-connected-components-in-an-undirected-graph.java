class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
    
    class UnionFind {
        // # of unions
        private int count;
        // track parent of each node
        private int[] parent;
        
        // n is the # of nodes
        public UnionFind(int n) {
            parent = new int[n];
            // init a node with parent pointing to itself
            for (int node = 0; node < n; ++node) {
                parent[node] = node;
            }
            this.count = n;
        }
        
        // check if 2 nodes are in the same union
        public boolean isConnected(int a, int b) {
            int rootA = find(a), rootB = find(b);
            
            return rootA == rootB;
        }
        
        // union 2 nodes
        public void union(int a, int b) {
            int rootA = find(a), rootB = find(b);
            if (rootA == rootB) return;
            // connect b's root to a's root
            // CAUTION
            parent[rootB] = rootA;
            // 1 less union
            --count;
        }
        
        // find the root of the node x
        public int find(int x) {
            if (parent[x] != x) {
                // recursively find and connect all nodes to 1 root
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public int count() {
            return this.count;
        }
    }
}