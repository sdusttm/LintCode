public class LintCode162 {

    public static void main(String[] args) {
        setZeroes(new int[][] {
            {1, 0},
            {1, 1},
        });
    }

    // m + n space complexity, not the best.
    public static void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix.length == 0) {
            return;
        }
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}