import java.util.Arrays;

public class LintCode14 {

    public static void main(String[] args) {
        int res = binarySearch(new int[] { 1,4,4,5,7,7,8,9,9,10 }, 9);
        System.out.print(res);
    }

    // space complexity explode
    public static int binarySearch_0(int[] nums, int target) {
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

    public static int binarySearch(int[] nums, int target) {
        // write your code here
        return binarySearchInternal(nums, target, 0, nums.length);
    }
    
    public static int binarySearchInternal(int[] nums, int target, int low, int high) {
        // write your code here
        if (low == high) {
            return -1;
        } else if (low + 1 == high) {
            return target == nums[low] ? low : -1;
        } else if (low + 2 == high) {
            return target == nums[low] ? low : target == nums[low + 1] ? low + 1 : -1;
        } else {
            int m_index = (low + high) / 2;
            int mid = nums[m_index];
            if (target < mid) {
                return binarySearchInternal(nums, target, 0, m_index);
            } else if (target == mid) {
                int potentialRes = binarySearchInternal(nums, target, low, m_index);
                return potentialRes == -1 ? m_index : potentialRes;
            } else {
                return binarySearchInternal(nums, target, m_index + 1, high);
            }
        }
    }
}