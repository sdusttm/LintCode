import java.util.Arrays;

public class LintCode14 {

    public static void main(String[] args) {
        int res = binarySearch(new int[] { 4, 5, 9, 9, 12, 13, 14, 15, 15, 18 }, 9);
        System.out.print(res);
    }

    // space complexity explode
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        } else if (nums.length == 2) {
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;
        } else {
            int m_index = nums.length / 2;
            int mid = nums[m_index];
            if (target < mid) {
                return binarySearch(Arrays.copyOfRange(nums, 0, m_index), target);
            } else if (target == mid) {
                int possibleLower = binarySearch(Arrays.copyOfRange(nums, 0, m_index), target);
                return possibleLower == -1 ? m_index : possibleLower;
            } else {
                int possibleHigher = binarySearch(Arrays.copyOfRange(nums, m_index + 1, nums.length), target);
                
                return possibleHigher == -1 ? -1 : m_index + 1 + possibleHigher;
            }
        }
    }
}