import java.util.Arrays;

/**
 * @author 废柴 2020/11/29 15:43
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] < (A[i - 1] + A[i - 2])) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
