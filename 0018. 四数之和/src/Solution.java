import java.util.*;

/**
 * @author 废柴 2020/10/5 14:57
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        fourSum(nums, target, result, new int[4], 0, 0, 0);
        return result;
    }

    private void fourSum(int[] nums, int target, List<List<Integer>> result, int[] item, int sum, int i, int start) {
        if (i == 4) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>(item.length);
                for (int it : item) {
                    list.add(it);
                }
                result.add(list);
            }
            return;
        }
        Integer previous = null;
        for (int j = start; j < nums.length - 3 + i; j++) {
            if (previous != null && previous == nums[j]) {
                continue;
            }
            previous = nums[j];
            sum += nums[j];
            if (sum > target && nums[j] >= 0) {
                break;
            }
            item[i] = nums[j];
            fourSum(nums, target, result, item, sum, i + 1, j + 1);
            sum -= nums[j];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-5, 5, 4, -3, 0, 0, 4, -2}, 4));
    }
}
