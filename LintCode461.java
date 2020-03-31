import java.util.Arrays;

public class LintCode461 {

    public static void main(String[] args) {
        int res = kthSmallest(3, new int[] { 2, 4, 1, 2, 5 });
        System.out.print(res);
    }

    public static int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums.length <= 3) {
            if (k > nums.length) {
                return -1;
            } else {
                Arrays.sort(nums);
                return nums[k - 1];
            }
        }

        int i = 0, j = nums.length - 2;
        int flag = nums[nums.length - 1];
        while (i < j) {
            while (i < j && nums[i] < flag) {
                i++;
            }

            while (i < j && nums[j] > flag) {
                j--;
            }

            if (i == nums.length - 2) {
                return kthSmallest(k, Arrays.copyOfRange(nums, 0, nums.length - 1));
            } else if (i == 0) {
                return kthSmallest(k, Arrays.copyOfRange(nums, 1, nums.length));
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (i + 1 == k) {
            return flag;
        } else if (i + 1 > k) {
            return kthSmallest(k, Arrays.copyOfRange(nums, 0, i));
        } else {
            return kthSmallest(k - i, Arrays.copyOfRange(nums, i, nums.length));
        }
    }
}