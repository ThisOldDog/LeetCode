import java.util.Arrays;

/**
 * @author 废柴 2020/10/11 13:09
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        boolean[] result = new boolean[]{false};
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        // 偶数
        if ((sum & 1) == 0) {
            hasHalf(nums, sum >> 1, result, 0, 0);
        }
        return result[0];
    }

    private void hasHalf(int[] nums, int target, boolean[] result, int i, int sum) {
        if (i == nums.length || result[0]) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (sum < target) {
                hasHalf(nums, target, result, j + 1, sum);
            } else if (sum == target) {
                result[0] = true;
                return;
            } else {
                return;
            }
            if (result[0]) {
                return;
            }
            sum -= nums[j];
        }
    }
}
