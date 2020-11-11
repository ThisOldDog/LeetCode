import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 废柴 2020/11/4 9:18
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        if (intervals.length == 0) return result;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        int mergeSize = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result[mergeSize][1]) {
                result[mergeSize][1] = Math.max(result[mergeSize][1], intervals[i][1]);
            } else {
                result[++mergeSize][0] = intervals[i][0];
                result[mergeSize][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(result, mergeSize + 1);
    }
}
