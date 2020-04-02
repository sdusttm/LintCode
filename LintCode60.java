public class LintCode60 {

    public static void main(String[] args) {
        int res = searchInsert(new int[]{}, 8);
        System.out.print(res);
    }

    // paste code here and add static:
    public static int searchInsert(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }
        
        if (target < A[0]) {
            return 0;
        }
        
        if (target > A[A.length - 1]) {
            return A.length;
        }
        
        int low = 0, high = A.length - 1;
        while(low < high - 1) {
            int i_mid = low + (high - low)/2;
            int mid = A[i_mid];
            if (mid == target) {
                return i_mid;
            } else if (target < mid) {
                high = i_mid;
            } else {
                low = i_mid;
            }
        }
        
        if (A[low] == target) {
            return low;
        } else {
            return high;
        }
    }
}