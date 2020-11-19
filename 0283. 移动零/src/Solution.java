/**
 * @author 废柴 2020/11/19 19:03
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int s = 0;
        while (nums[s] == 0) {
            s++;
        }
        int e = s;
        while (s < nums.length &&e < nums.length) {
            if (nums[e] == 0) {
                e++;
            } else {
                nums[s] = nums[e];
                nums[e] = 0;
                s++;
            }
        }
    }
}
