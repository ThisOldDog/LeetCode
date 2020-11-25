/**
 * @author 废柴 2020/11/25 19:40
 */
public class Solution {
    /*
     * 1. 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 2. 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 3. 重复步骤 2 ，直到你没法从 s 中选择字符。
     * 4. 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 5. 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 6. 重复步骤 5 ，直到你没法从 s 中选择字符。
     * 7. 复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     */
    public String sortString(String s) {
        char[] cs = s.toCharArray();
        int[] b = new int[26];
        for (char c : cs) {
            b[c - 'a'] += 1;
        }
        char[] r = new char[cs.length];
        int i = 0;
        while (i < cs.length) {
            for (int j = 0; j < b.length && i < cs.length; j++) {
                if (b[j] > 0) {
                    b[j] -= 1;
                    r[i++] = (char) (j + 'a');
                }
            }
            for (int j = b.length - 1; j >= 0 && i < cs.length; j--) {
                if (b[j] > 0) {
                    b[j] -= 1;
                    r[i++] = (char) (j + 'a');
                }
            }
        }
        return new String(r);
    }
}
