public class ConnectingGraph {

    private int[] parent;
    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
        // do intialization if necessary
        this.parent = new int[n + 1];
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = a;
        while (this.parent[rootA] != 0) {
            rootA = this.parent[rootA];
        }
        
        int rootB = b;
        while (this.parent[rootB] != 0) {
            rootB = this.parent[rootB];
        }
        
        if (rootA != 0 && rootA == rootB) {
            return;
        } else {
            this.parent[rootB] = rootA;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int rootA = a;
        while (this.parent[rootA] != 0) {
            rootA = this.parent[rootA];
        }
        
        int rootB = b;
        while (this.parent[rootB] != 0) {
            rootB = this.parent[rootB];
        }
        
        return (rootA != 0 && rootA == rootB);
    }
}