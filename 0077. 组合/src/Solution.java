import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/9/8 10:00
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            oneResult.add(0);
        }
        combine(n, k, result, oneResult, 0, 1);
        return result;
    }

    public void combine(int n, int k, List<List<Integer>> result, List<Integer> oneResult, int index, int start) {
        if (index == k) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = start; i <= n - k + index + 1; i++) {
            oneResult.set(index, i);
            combine(n, k, result, oneResult, index + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 4));
    }
}
