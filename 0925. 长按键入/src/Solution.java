/**
 * @author 废柴 2020/10/21 9:06
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] n = name.toCharArray(), t = typed.toCharArray();
        int i = 0, j = 0;
        for (; i < n.length && j < t.length; i++, j++) {
            while (j < t.length && n[i] != t[j] && j > 0 && t[j] == t[j - 1]) {
                j++;
            }
            if (j == t.length || n[i] != t[j]) {
                return false;
            }
        }
        if (i < n.length) {
            return false;
        }
        for (int k = j; k < t.length - 1; k++) {
            if (t[k] != t[k + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("", ""));
        System.out.println(new Solution().isLongPressedName("alex", "aaleex"));
        System.out.println(new Solution().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new Solution().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new Solution().isLongPressedName("laiden", "laiden"));
        System.out.println(new Solution().isLongPressedName("saeedi", "ssaaeediixxxiii"));
        System.out.println(new Solution().isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(new Solution().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    }
}