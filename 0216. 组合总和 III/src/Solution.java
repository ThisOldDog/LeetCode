import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/9/11 11:31
 */
public class Solution {
    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, new ArrayList<>(), new int[k], 0, 0, 0);
    }

    private <E> List<List<Integer>> combinationSum3(int k, int n, ArrayList<List<Integer>> result, int[] oneResult, int i, int sum, int cnt) {
        if (cnt >= k) {
            return result;
        }
        for (; i < nums.length; ++i) {
            int s = sum + nums[i];
            if (s < n) {
                oneResult[cnt] = nums[i];
                combinationSum3(k, n, result, oneResult, i + 1, s, cnt + 1);
            } else if (s == n) {
                oneResult[cnt] = nums[i];
                if ((cnt + 1) == k) {
                    result.add(asList(oneResult));
                }
            }
        }
        return result;
    }

    private List<Integer> asList(int[] oneResult) {
        List<Integer> list = new ArrayList<>();
        for (int i : oneResult) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }

}
