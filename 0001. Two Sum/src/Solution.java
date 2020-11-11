import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int result = target - nums[i];
            if (numsMap.containsKey(result)) {
                return new int[]{numsMap.get(result), i};
            }
            numsMap.put(nums[i], i);
        }
        throw new RuntimeException("Not Found.");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
