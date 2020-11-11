import java.util.Arrays;

/**
 * @author 废柴 2020/11/4 9:31
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        boolean inserted = false;
        int mergeSize = 0, i = 0;
        if (intervals[0][0] >= newInterval[0]) {
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            inserted = true;
        } else {
            result[0][0] = intervals[0][0];
            result[0][1] = intervals[0][1];
            ++i;
        }
        for (; i < intervals.length; i++) {
            if (!inserted && newInterval[0] <= intervals[i][0]) {
                if (newInterval[0] > result[mergeSize][1]) {
                    result[++mergeSize][0] = newInterval[0];
                    result[mergeSize][1] = newInterval[1];
                } else {
                    result[mergeSize][1] = Math.max(result[mergeSize][1], newInterval[1]);
                }
                --i;
                inserted = true;
            } else {
                if (intervals[i][0] <= result[mergeSize][1]) {
                    result[mergeSize][1] = Math.max(result[mergeSize][1], intervals[i][1]);
                } else {
                    result[++mergeSize][0] = intervals[i][0];
                    result[mergeSize][1] = intervals[i][1];
                }
            }
        }
        if (!inserted) {
            if (newInterval[0] > result[mergeSize][1]) {
                result[++mergeSize][0] = newInterval[0];
                result[mergeSize][1] = newInterval[1];
            } else {
                result[mergeSize][1] = Math.max(result[mergeSize][1], newInterval[1]);
            }
        }
        return Arrays.copyOf(result, mergeSize + 1);
    }

    // [[1,2],[3,5],[6,7],[8,10],[12,16]]
    //[4,8]
    public static void main(String[] args) {
        new Solution().insert(new int[][]{{1, 5}}, new int[]{2, 3});
    }
}
