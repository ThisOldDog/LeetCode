import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/11/11 19:41
 */
public class Solution {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] cache = new ArrayList[]{
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>()
        };
        char[] r = ring.toCharArray(), k = key.toCharArray();
        for (int i = 0; i < r.length; i++)
            cache[r[i] - 'a'].add(i);

        int[][] map = new int[k.length][r.length];
        for (int i : cache[k[0] - 'a']) {
            map[0][i] = distance(0, i, r.length) + 1;
        }
        for (int i = 1; i < k.length; i++) {
            List<Integer> es = cache[k[i] - 'a'];
            for (int e : es) {
                map[i][e] = Integer.MAX_VALUE;
                for (int j = 0; j < r.length; j++) {
                    if (map[i - 1][j] != 0) {
                        map[i][e] = Math.min(map[i][e], 1 + distance(j, e, r.length) + map[i - 1][j]);
                    }
                }
            }

        }
        int result = Integer.MAX_VALUE;
        for (int i : map[k.length - 1]) {
            result = i == 0 ? result : Math.min(result, i);
        }
        return result;
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
