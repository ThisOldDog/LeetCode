/**
 * @author 废柴 2020/9/14 15:09
 */
public class Solution {
    public int integerReplacement(int n) {
        int[] result = {Integer.MAX_VALUE};
        integerReplacement(n, 0, result);
        return result[0];
    }

    private void integerReplacement(long n, int cnt, int[] minCnt) {
        if (cnt >= minCnt[0]) {
            return;
        }
        if (n == 1) {
            minCnt[0] = Math.min(cnt, minCnt[0]);
        } else if ((n & 1) == 0) {
            integerReplacement(n >> 1, cnt + 1,  minCnt);
        } else {
            integerReplacement(n + 1, cnt + 1, minCnt);
            integerReplacement(n - 1, cnt + 1, minCnt);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(2147483647));
    }
}
