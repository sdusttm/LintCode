public class ConnectingGraph2 {
    
    private int[] parent;
    private int[] count;
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        // do intialization if necessary
        this.parent = new int[n + 1];
        this.count = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            this.count[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB && rootA != 0) {
            return;
        } else {
            this.parent[rootB] = rootA;
            this.count[rootA] += this.count[rootB];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int root = this.find(a);
        return this.count[root];
        
    }
    
    public int find(int a) {
        int root = a;
        while (parent[root] != 0) {
            root = parent[root];
        } 
        
        return root;
    }
}