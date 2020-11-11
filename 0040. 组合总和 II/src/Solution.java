import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 废柴 2020/9/10 10:28
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, new ArrayList<>(), new int[candidates.length], 0, 0, 0);
    }

    private <E> List<List<Integer>> combinationSum2(int[] candidates, int target, List<List<Integer>> result, int[] item, int i, int n, int sum) {
        while (i < candidates.length) {
            int s = sum + candidates[i];
            if (s > target) {
                return result;
            } else if (s == target) {
                item[n] = candidates[i];
                result.add(asArray(item, n));
            } else {
                item[n] = candidates[i];
                combinationSum2(candidates, target, result, item, i + 1, n + 1, s);
            }
            int k = i + 1;
            while (k < candidates.length && candidates[k] == candidates[i]) {
                k++;
            }
            i = k;
        }
        return result;
    }

    private List<Integer> asArray(int[] item, int n) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            array.add(item[i]);
        }
        Collections.sort(array);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 1, 1, 2, 3, 3, 3, 1, 2, 2}, 5));
    }
}
