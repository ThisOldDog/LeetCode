/**
 * @author 废柴 2020/12/13 16:23
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i] - nums[i - 1];
            if (current > 0) {
                up = down + 1;
            } else if (current < 0) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})); // 6
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));  // 7
    }
}
