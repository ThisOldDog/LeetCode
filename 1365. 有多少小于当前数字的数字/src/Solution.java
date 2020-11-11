import java.util.Arrays;

/**
 * @author 废柴 2020/10/26 9:38
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] t = Arrays.copyOf(nums, nums.length), bucket = new int[101];
        Arrays.sort(t);
        for (int i = t.length - 1; i >= 0; i--) {
            bucket[t[i]] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = bucket[nums[i]];
        }
        return nums;
    }
}
