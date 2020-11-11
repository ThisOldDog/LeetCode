/**
 * @author 废柴 2020/11/7 16:43
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
