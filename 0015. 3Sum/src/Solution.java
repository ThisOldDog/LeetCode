import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = nums.length - 1, target = -nums[i];
                while (j < k) {
                    int value = nums[j] + nums[k] - target;
                    if (value == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < nums.length - 1 && nums[j + 1] == nums[j]) ++j;
                        while (k > 0 && nums[k - 1] == nums[k]) --k;
                        ++j;
                        --k;
                    } else if (value < 0) {
                        while (j < nums.length - 1 && nums[j + 1] == nums[j]) ++j;
                        ++j;
                    } else {
                        while (k > 0 && nums[k - 1] == nums[k]) --k;
                        --k;
                    }

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
