import java.util.ArrayDeque;
import java.util.Objects;

/**
 * @author 废柴 2020/10/19 9:10
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] c1 = S.toCharArray(), c2 = T.toCharArray();
        ArrayDeque<Character> s1 = new ArrayDeque<>(c1.length), s2 = new ArrayDeque<>(c2.length);
        for (char c : c1) {
            if (c == '#') {
                s1.pollFirst();
            } else {
                s1.push(c);
            }
        }
        for (char c : c2) {
            if (c == '#') {
                s2.pollFirst();
            }else {
                s2.push(c);
            }
        }
        boolean equal = true;
        while (equal && (!s1.isEmpty() || !s2.isEmpty())) {
            equal = Objects.equals(s1.pollFirst(), s2.pollFirst());
        }
        return equal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#####c", "ad#c"));
    }
}
