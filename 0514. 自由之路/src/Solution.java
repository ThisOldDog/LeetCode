import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 废柴 2020/11/11 19:41
 */
public class Solution {
    public int findRotateSteps(String ring, String key) {
        int[] result = {Integer.MAX_VALUE};
        Map<Character, List<Integer>> cache = new HashMap<>();
        char[] r = ring.toCharArray(), k = key.toCharArray();
        for (int i = 0; i < r.length; i++)
            cache.compute(r[i], (e, o) -> o == null ? new ArrayList<>() : o).add(i);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : cache.get(k[0])) {
            map.put(i, distance(0, i, r.length) + 1);
        }
        for (int i = 1; i < k.length; i++) {
            Map<Integer, Integer> nextMap = new HashMap<>();
            List<Integer> idxs = cache.get(k[i]);
            map.forEach((idx, cnt) -> {
                for (int e : idxs)
                    nextMap.merge(e, cnt + 1 + distance(idx, e, r.length), Math::min);
            });
            map = nextMap;
        }
        map.forEach((e, c) -> result[0] = Math.min(result[0], c));
        return result[0];
    }

    private int distance(int i, int kidx, int length) {
        int d = Math.abs(kidx - i);
        return Math.min(d, length - d);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRotateSteps("godding", "gd"));
        System.out.println(new Solution().findRotateSteps("edcba", "abcde"));
        System.out.println(new Solution().findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
