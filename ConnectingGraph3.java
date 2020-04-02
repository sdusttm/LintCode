public class ConnectingGraph3 {
    
    int parent[];
    int count;
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            this.parent[i] = i;
        }
        this.count = n;
    }
    
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            this.parent[rootB] = rootA;
            this.count--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return this.count;
    }
    
    int find(int a) {
        int root = a;
        while (this.parent[root] != root) {
            root = this.parent[root];
        } 
        
        return root;
    }
}