import java.util.HashMap;
import java.util.Map;

/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> window = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (window.containsKey(s.charAt(j))) {
                i = Math.max(window.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            window.put(s.charAt(j), j++ + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
