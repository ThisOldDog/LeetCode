import java.util.HashMap;
import java.util.Map;

/**
 * @author 废柴 2020/10/15 11:11
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Map<Integer, Integer> bucket = new HashMap<>(nums.length);
        for (int num : nums) {
            bucket.put(num, -1);
        }
        int max = 1;
        for (int num : nums) {
            if (bucket.get(num) >>> 31 == 1) {
                int cnt = 1, next = num + 1;
                Integer continuous = -1;
                while (continuous != null) {
                    continuous = bucket.get(next);
                    if (continuous != null) {
                        if (continuous >>> 31 == 1) {
                            bucket.put(next, 0);
                            cnt++;
                        } else {
                            cnt += continuous;
                            break;
                        }
                    }
                    next++;
                }
                bucket.put(num, cnt);
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{5, 1, 2, 2, 3, 4}));
    }
}
