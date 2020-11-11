/**
 * @author 废柴 2020/9/21 20:23
 */
public class Solution {
    public void reverseString(char[] s) {
        int half = s.length / 2;
        for (int i = 0; i < half; ++i) {
            int opposite = s.length - 1 - i;
            s[i] += s[opposite];
            s[opposite] = (char) (s[i] - s[opposite]);
            s[i] -= s[opposite];
        }
    }

    public static void main(String[] args) {
        char a = 'z';
        a -= 1;
        a = (char) (a - 1);
    }
}
