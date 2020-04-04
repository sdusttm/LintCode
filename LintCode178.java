public class LintCode178 {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // for a valid tree, count of nodes - 1 must be count of edges
        if (n - 1 != edges.length) {
            return false;
        }
        
        union_Find uF = new union_Find(n);
        for (int i = 0; i < edges.length; i++) {
            boolean result = uF.Union(edges[i][0], edges[i][1]);
            if (!result) return false;
        }
        
        return true;
    }
    
    class union_Find {
        public int[] parent;
        
        public union_Find(int n) {
            this.parent = new int[n];
            for(int i = 0; i < parent.length; i++) {
                this.parent[i] = -1;
            }
        }
        
        public boolean Union(int x, int y) {
            int rootA = this.Find(x);
            int rootB = this.Find(y);

            // find both belong to the same group -> loop
            if (rootA == rootB && rootB != -1) {
                return false;
            }
            
            this.parent[rootB] = rootA;
            this.parent[rootA] = rootA;
            return true;
        }
        
        public int Find(int x) {
            int root = x;
            while (this.parent[root] != -1 && this.parent[root] != root) {
                root = this.parent[root];
            } 
            
            while (this.parent[root] != -1 && this.parent[root] != root) {
                int p = this.parent[x];
                this.parent[x] = root;
                x = p;
            }
            
            return root;
        }
    }
}