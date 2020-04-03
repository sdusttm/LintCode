import java.util.ArrayList;
import java.util.List;

public class Islands2 {   
    int[] next;
    int rows;
    int cols;
    int count = 0;
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        this.next = new int[m*n];
        for (int i = 0; i < this.next.length; i++) {
            this.next[i] = -1;
        }
        
        this.rows = n;
        this.cols = m;
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (operators == null || operators.length == 0) {
            return res;
        }
        
        for(int i = 0; i < operators.length; i++) {
            res.add(this.addIsland(operators[i]));
        }
        
        return res;
    }
    
    public int getId(Point p) {
        return this.cols*p.x + p.y;
    }
    
    public int addIsland(Point p) {
        if (this.next[getId(p)] != -1) {
            return this.count;
        }
        
        Point up = new Point(p.x - 1, p.y);
        Point down = new Point(p.x + 1, p.y);
        Point left = new Point(p.x, p.y - 1);
        Point right = new Point(p.x, p.y + 1);
        
        this.next[getId(p)] = getId(p); // set to exist
        this.count ++;
        
        if (isValid(up) && (this.next[getId(up)] != -1)) {
            this.connect(p, up);
        }
        
        if (isValid(down) && (this.next[getId(down)] != -1)) {
            this.connect(p, down);
        }
        
        if (isValid(left) && (this.next[getId(left)] != -1)) {
            this.connect(p, left);
        }
        
        if (isValid(right) && (this.next[getId(right)] != -1)) {
            this.connect(p, right);
        }
        
        return this.count;
    }
    
    public void connect(Point p, Point q) {
        if (this.findRootId(p) != this.findRootId(q)) {
            this.next[findRootId(p)] = findRootId(q);    
            this.count --;
        }
    }
    
    public int findRootId(Point p) {
        int root = this.getId(p);
        
        while (this.next[root] != -1 && this.next[root] != root) {
            root = this.next[root];
        }
        
        return root;
    }
    
    public boolean isValid(Point p) {
        return p.x >= 0 && p.x < this.rows && p.y >=0 && p.y < this.cols;
    }
}