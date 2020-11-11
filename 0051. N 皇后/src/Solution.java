import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/9/3 20:32
 */
public class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] chessboard = new int[n][n];
        solveNQueens(chessboard, 0, n, result);
        return result;
    }

    private static void solveNQueens(int[][] chessboard, int current, int n, List<List<String>> result) {
        if (current == n) {
            return;
        }
        for (int index = 0; index < n; index++) {
            chessboard[current][index] = 1;
            if (check(chessboard, current, index, n))
                if (current + 1 == n)
                    addResult(result, chessboard, n);
                else
                    solveNQueens(chessboard, current + 1, n, result);
            chessboard[current][index] = 0;
        }
    }

    private static void addResult(List<List<String>> result, int[][] chessboard, int n) {
        List<String> oneResult = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (chessboard[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            oneResult.add(sb.toString());
        }
        result.add(oneResult);
    }

    private static boolean check(int[][] chessboard, int x, int y, int n) {
        // 从左到右
        for (int i = 0; i < n; ++i) {
            if (i == x) {
                continue;
            }
            if (chessboard[i][y] == 1) {
                return false;
            }
        }
        // 从上到下
        for (int j = 0; j < n; ++j) {
            if (j == y) {
                continue;
            }
            if (chessboard[x][j] == 1) {
                return false;
            }
        }
        // 从当前点到左上
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        // 从当前点到右下
        for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        // 从当前点到左下
        for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        // 从当前点到右上
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
