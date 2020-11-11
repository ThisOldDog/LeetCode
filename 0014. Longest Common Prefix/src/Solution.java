/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            if (i == strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}));
    }
}
