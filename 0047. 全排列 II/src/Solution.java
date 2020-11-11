import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 废柴 2020/9/18 9:50
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(nums, new ArrayList<>(), new int[nums.length], new HashSet<>(), new boolean[nums.length], 0);
    }

    public List<List<Integer>> permuteUnique(int[] nums, List<List<Integer>> result, int[] item, Set<String> distinctMap, boolean[] exists, int i) {
        if (i == nums.length) {
            StringBuilder sb = new StringBuilder();
            List<Integer> oneResult = new ArrayList<>();
            for (int j = 0; j < item.length; j++) {
                sb.append(item[j]).append(',');
                oneResult.add(item[j]);
            }
            String str = sb.toString();
            if (!distinctMap.contains(str)) {
                result.add(oneResult);
                distinctMap.add(str);
            }
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (exists[j]) {
                    continue;
                }
                exists[j] = true;
                item[i] = nums[j];
                permuteUnique(nums, result, item, distinctMap, exists, i + 1);
                exists[j] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}
