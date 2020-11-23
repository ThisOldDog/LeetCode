import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author 废柴 2020/11/23 9:25
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparing(Function.identity(), (e1, e2) -> e1[0] == e2[0] ? Integer.compare(e1[1], e2[1]) : Integer.compare(e1[0], e2[0])));
        int cnt = 1, s = points[0][0], e = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > e) {
                cnt++;
                s = points[i][0];
                e = points[i][1];
            } else {
                s = Math.max(s, points[i][0]);
                e = Math.min(e, points[i][1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // [[10,16],[2,8],[1,6],[7,12]] -> 2
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {10, 16},
//                {2, 8},
//                {1, 6},
//                {7, 12}
//        }));
        // [[10,16],[2,8],[1,6],[7,12]] -> 2
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {1, 2},
//                {3, 4},
//                {5, 6},
//                {7, 8}
//        }));
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {1, 2},
//                {2, 3},
//                {3, 4},
//                {4, 5}
//        }));
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {1, 2},
//        }));
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {1, 5},
//                {2, 8},
//                {6, 10},
//        }));
        // [[-2147483648,2147483647]]
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {-2147483648, 2147483647}
//        }));
        // [[-2147483646,-2147483645],[2147483646,2147483647]] -> 2
        System.out.println(new Solution().findMinArrowShots(new int[][]{
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        }));
    }
}
