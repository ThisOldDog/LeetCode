import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author 废柴 2020/11/6 9:04
 */
public class Solution {

    public int[] sortByBits(int[] arr) {
        int[][] a = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            a[i][0] = arr[i];
            int cnt = 0, n = arr[i];
            while (n != 0) {
                if ((n & 1) == 1) {
                    cnt++;
                }
                n >>= 1;
            }
            a[i][1] = cnt;
        }
        Arrays.sort(a, Comparator.comparing(Function.identity(), (o1, o2) ->
                o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]
        ));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i][0];
        }
        return arr;
    }
}
