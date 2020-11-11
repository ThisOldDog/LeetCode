/**
 * @author 废柴 2020/10/25 17:41
 */
public class Solution {

    public int longestMountain(int[] A) {
        int max = 0, status = 0 /* 0 初始， 1 上升， 2 下降*/, cnt = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (status == 0) {
                    status = 1;
                    cnt = 2;
                } else if (status == 1) {
                    cnt++;
                } else {
                    max = Integer.max(max, cnt);
                    status = 1;
                    cnt = 2;
                }
            } else if (A[i] < A[i - 1]) {
                if (status == 1) {
                    status = 2;
                    cnt++;
                } else if (status == 2) {
                    cnt++;
                }
            } else if (A[i] == A[i - 1]) {
                if (status == 1) {
                    status = 0;
                    cnt = 0;
                } else if (status == 2) {
                    status = 0;
                    max = Integer.max(max, cnt);
                }
            }
        }
        max = status == 2 ? Integer.max(max, cnt) : max;
        return max < 3 ? 0 : max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestMountain(new int[]{1, 3, 3, 1}));
        ;
    }
}
