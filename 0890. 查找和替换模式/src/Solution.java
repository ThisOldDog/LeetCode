import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 废柴 2020/9/21 19:53
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] law = law(pattern.toCharArray());
        for (String word : words) {
            if (word.length() == law.length && Arrays.equals(law, law(word.toCharArray())))
                result.add(word);
        }
        return result;
    }

    private int[] law(char[] arrays) {
        int[] law = new int[arrays.length];
        int[] bucket = new int[27];
        for (int i = 0, index = 1; i < arrays.length; ++i) {
            int bucketIndex = arrays[i] - 'a';
            int tIndex;
            if ((tIndex = bucket[bucketIndex]) == 0) {
                law[i] = bucket[bucketIndex] = index++;
            } else {
                law[i] = tIndex;
            }
        }
        System.out.println(Arrays.toString(arrays) + " : " + Arrays.toString(law));
        return law;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
