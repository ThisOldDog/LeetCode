import java.util.Arrays;

/**
 * @author 废柴 2020/11/10 9:29
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {

            int index = -1, min = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j] && nums[j] < min) {
                    index = j;
                    min = nums[j];
                }
            }
            if (index != -1) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        for (int i = 0, j = nums.length - 1; i < j; i++, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
//        int[] n = new int[]{4, 2, 0, 2, 3, 2, 0};
//        int[] n = new int[]{1, 3, 2};
        int[] n = new int[]{2, 3, 1};
        new Solution().nextPermutation(n);
        System.out.println(Arrays.toString(n));
    }
}
