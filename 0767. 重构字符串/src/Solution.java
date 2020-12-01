import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 废柴 2020/11/30 20:21
 */
public class Solution {
    public String reorganizeString(String S) {
        char[] s = S.toCharArray();
        int[][] box = new int[26][2];
        for (char c : s) {
            int idx = c - 'a';
            box[idx][0] = c;
            box[idx][1] += 1;
        }
        Arrays.sort(box, Comparator.comparingInt(e -> ((int[]) e)[1]).reversed());
        int idx = 0, interval = (s.length + 1) / box[0][1], start = 1;
        if (interval == 1) {
            return "";
        }
        for (int i = 0; i < box.length; i++) {
            int j = box[i][1];
            while (j > 0) {
                j--;
                s[idx] = (char) box[i][0];
                idx += interval;
                if (idx >= s.length) {
                    idx = start++;
                }
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().reorganizeString("vvvlo"));
//        System.out.println(new Solution().reorganizeString("aab"));
//        System.out.println(new Solution().reorganizeString("aaab"));
        System.out.println(new Solution().reorganizeString("abbabbaaab"));
    }
}
