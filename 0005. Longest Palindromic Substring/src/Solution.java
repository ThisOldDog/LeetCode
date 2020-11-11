/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int startIndex = 0, endIndex = 0;
        String ans = s.substring(0, Math.min(s.length(), 1));
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                for (int j = 0; i + j < chars.length && i - j - 1 >= 0; j++) {
                    if (chars[i + j] != chars[i - j - 1]) {
                        break;
                    }
                    startIndex = i - j - 1;
                    endIndex = i + j;
                }
            }
            if (!s.isEmpty() && ans.length() < endIndex - startIndex + 1) {
                ans = s.substring(startIndex, endIndex + 1);
            }
            if (i > 1 && chars[i] == chars[i - 2]) {
                for (int j = 0; i + j < chars.length && i - j - 2 >= 0; j++) {
                    if (chars[i + j] != chars[i - j - 2]) {
                        break;
                    }
                    startIndex = i - j - 2;
                    endIndex = i + j;
                }
            }
            if (!s.isEmpty() && ans.length() < endIndex - startIndex + 1) {
                ans = s.substring(startIndex, endIndex + 1);
            }
        }
        if (!s.isEmpty() && ans.length() < endIndex - startIndex + 1) {
            ans = s.substring(startIndex, endIndex + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
