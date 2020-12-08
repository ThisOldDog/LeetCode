/**
 * @author 废柴 2020/12/7 19:24
 */
public class Solution {
    public int matrixScore(int[][] A) {
        // 第一列全变 1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = (A[i][j] + 1) & 1;
                }
            }
        }
        // 其他的列 变 1 更多
        for (int i = 1; i < A[0].length; i++) {
            int sizeOf1 = 0;
            for (int j = 0; j < A.length; j++) {
                sizeOf1 += A[j][i];
            }
            if (A.length - sizeOf1 > sizeOf1) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = (A[j][i] + 1) & 1;
                }
            }
        }
        // 计算结果
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int num = 0;
            for (int j = 0; j < A[i].length; j++) {
                num <<= 1;
                num += A[i][j];
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().matrixScore(new int[][]{{0, 1, 1}, {1, 1, 1}, {0, 1, 0}}));
    }
}
