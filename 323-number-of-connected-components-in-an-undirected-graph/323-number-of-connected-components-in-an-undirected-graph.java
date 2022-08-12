class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        // build the uf graph per edges
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.count();
    }
    
    class UnionFind {
        // count connected unions
        private int count;
        // track the parent of each node
        private int[] parent;
        
        // n is the # of nodes
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }        
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ) return;
                       
            // unite (connect one's root to the other's root)
            parent[rootP] = rootQ;
            this.count--;
                      
        }
        
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            return rootP == rootQ;
        }
        
        // find root and compress path
        public int find(int x) {
            if (parent[x] != x) {
                // recurse until find the root, and set all nodes on the path parent to the root
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public int count() {
            return this.count;
        }
    }
}