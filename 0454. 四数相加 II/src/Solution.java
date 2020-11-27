import java.util.HashMap;
import java.util.Map;

/**
 * @author 废柴 2020/11/27 17:20
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        Map<Integer, Integer> abs = new HashMap<>(A.length * B.length * 4 / 3);
        for (int a : A) {
            for (int b : B) {
                abs.compute(a + b, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                cnt += abs.getOrDefault(-(c + d), 0);
            }
        }
        return cnt;
    }
}
