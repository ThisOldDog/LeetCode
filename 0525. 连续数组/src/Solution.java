import java.util.HashMap;
import java.util.Map;

/**
 * @author 废柴 2020/9/23 20:25
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0)
                sum += 1;
            else
                sum -= 1;
            Integer index;
            if ((index = map.get(sum)) == null)
                map.put(sum, i);
            else
                max = Math.max(max, i - index);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1}));
    }
}
