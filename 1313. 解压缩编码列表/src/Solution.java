import java.util.Arrays;

/**
 * @author 废柴 2020/9/27 16:44
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        int[] result = new int[nums.length << 1];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int k = nums[i];
            while (k > 0) {
                k--;
                if (index == result.length) {
                    result = Arrays.copyOf(result, index << 1);
                }
                result[index++] = nums[i + 1];
            }
        }
        result = Arrays.copyOf(result, index);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decompressRLElist(new int[]{1, 2, 3, 4})));
    }
}
