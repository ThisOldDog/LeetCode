/**
 * @author 废柴 2020/12/18 17:08
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] sa = s.toCharArray(), ta = t.toCharArray();
        int ss = 0, st = 0;
        for (char c : sa) {
            ss += c;
        }
        for (char c : ta) {
            st += c;
        }
        return (char) (st - ss);
    }
}
