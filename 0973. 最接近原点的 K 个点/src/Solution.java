import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 废柴 2020/11/9 19:51
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(e -> (e[0] & Integer.MAX_VALUE) + (e[1] & Integer.MAX_VALUE)));
        return Arrays.copyOf(points, K);
    }
}
