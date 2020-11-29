import java.util.Arrays;

/**
 * @author 废柴 2020/11/27 17:42
 */
public class Solution {
    public int maximumGap(int[] nums) {
        // 1 10 0 100
        int[] result = {0, 0, 0};
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i] - nums[i - 1];
            if (v > result[0]) {
                result[0] = v;
                result[1] = i;
                result[2] = i - 1;
            }
        }
        for (int i = 0; i < ; i++) {
            
        }
        return result[0];
    }
}
