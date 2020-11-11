/**
 * @author 废柴 2020/10/17 19:24
 */
public class Solution {
    public int totalNQueens(int n) {
        return totalNQueens(new boolean[n][n], new boolean[n], new boolean[n], new boolean[n << 1], new boolean[n << 1], 0, new int[1]);
    }

    private int totalNQueens(boolean[][] map, boolean[] top2Bottom, boolean[] left2Right, boolean[] leftTop2RightBottom, boolean[] leftBottom2RightTop, int cnt, int[] result) {
        if (cnt == map.length) {
            result[0] += 1;
            return result[0];
        }
        for (int i = 0; i < map.length; i++) {
            int lt2rb = map.length - 1 + i - cnt, lb2rt = cnt + i;
            if (!top2Bottom[i] && !left2Right[cnt] && !leftTop2RightBottom[lt2rb] && !leftBottom2RightTop[lb2rt]) {
                map[cnt][i] = true;
                top2Bottom[i] = left2Right[cnt] = leftTop2RightBottom[lt2rb] = leftBottom2RightTop[lb2rt] = true;
                totalNQueens(map, top2Bottom, left2Right, leftTop2RightBottom, leftBottom2RightTop, cnt + 1, result);
                top2Bottom[i] = left2Right[cnt] = leftTop2RightBottom[lt2rb] = leftBottom2RightTop[lb2rt] = false;
            }
        }
        return result[0];
    }
}
