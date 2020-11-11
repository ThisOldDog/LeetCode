import java.util.Arrays;

/**
 * @author 废柴 2020/10/16 9:50
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
