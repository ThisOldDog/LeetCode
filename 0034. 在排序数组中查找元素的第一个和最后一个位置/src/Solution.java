import java.util.Arrays;

/**
 * @author 废柴 2020/12/1 9:46
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i >= 0) {
            int[] r = new int[2];
            int k = i;
            while (k >= 0 && nums[k] == target) {
                k--;
            }
            r[0] = k + 1;
            k = i;
            while (k < nums.length && nums[k] == target) {
                k++;
            }
            r[1] = k - 1;
            return r;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
