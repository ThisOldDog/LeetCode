import java.util.ArrayList;
import java.util.List;

/**
 * @author 废柴 2020/10/14 10:08
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[][] bucket = new int[26][2];
        for (char c : A[0].toCharArray()) {
            bucket[c - 'a'][0] += 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                bucket[c - 'a'][1] += 1;
            }
            for (int j = 0; j < bucket.length; j++) {
                bucket[j][0] = Math.min(bucket[j][0], bucket[j][1]);
                bucket[j][1] = 0;
            }
        }
        List<String> result = new ArrayList<>();
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j][0] > 0) {
                bucket[j][0] -= 1;
                result.add(String.valueOf((char) (j + 'a')));
            }
        }
        return result;
    }
}
