import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 废柴 2020/11/14 20:57
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] order = new int[1001];
        for (int i = 0; i < arr2.length; i++) {
            order[arr2[i]] = i + 1;
        }
        return Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.comparingInt(n -> (order[n] == 0 ? 1001 + n : order[n])))
                .mapToInt(e -> e)
                .toArray();
    }
}
