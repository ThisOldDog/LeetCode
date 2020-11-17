import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 废柴 2020/11/17 9:04
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] r = new int[R * C][2];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                r[idx][0] = i;
                r[idx++][1] = j;
            }
        }
        Arrays.sort(r, Comparator.comparingInt(e -> Math.abs(e[0] - r0) + Math.abs(e[1] - c0)));
        return r;
    }
}
