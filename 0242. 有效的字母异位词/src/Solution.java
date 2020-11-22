import java.util.Arrays;

/**
 * @author 废柴 2020/11/22 15:43
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        if (ss.length == ts.length) {
            Arrays.sort(ss);
            Arrays.sort(ts);
            return Arrays.equals(ss, ts);
        }
        return false;
    }
}
