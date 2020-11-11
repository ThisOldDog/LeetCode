import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 废柴 2020/10/22 9:50
 */
public class Solution {
    private final int PROCESSED = Integer.MAX_VALUE;

    public List<Integer> partitionLabels(String S) {
        int[][] bucket = new int[26][2];
        char[] s = S.toCharArray();
        for (int i = 0; i < bucket.length; i++) {
            bucket[i][0] = bucket[i][1] = PROCESSED;
        }
        for (int i = 0; i < s.length; i++) {
            int index = s[i] - 'a';
            if (bucket[index][0] == PROCESSED) {
                bucket[index][0] = bucket[index][1] = i;
            } else {
                bucket[index][1] = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (true) {
            Arrays.sort(bucket, Comparator.comparingInt(item -> item[0]));
            if (bucket[0][0] == PROCESSED) {
                break;
            }
            int left = bucket[0][0], right = bucket[0][1];
            bucket[0][0] = bucket[0][1] = PROCESSED;
            for (int i = 1; i < bucket.length; i++) {
                if (bucket[i][0] > left && bucket[i][1] < right) {
                    bucket[i][0] = bucket[i][1] = PROCESSED;
                } else if (bucket[i][0] < left && bucket[i][1] > left && bucket[i][1] < right) {
                    left = bucket[i][0];
                    bucket[i][0] = bucket[i][1] = PROCESSED;
                } else if (bucket[i][0] > left && bucket[i][0] < right && bucket[i][1] > right) {
                    right = bucket[i][1];
                    bucket[i][0] = bucket[i][1] = PROCESSED;
                }
            }
            result.add(right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
