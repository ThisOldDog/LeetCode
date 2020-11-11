/**
 * @author 废柴 2020/9/23 20:32
 */
public class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int size = 0;
        for (char c : s.toCharArray()) {
            if (size == 0) {
                stack[size++] = c;
            } else {
                char first = stack[size - 1];
                if (first == '(' && c == ')') {
                    size--;
                } else if (first == '{' && c == '}') {
                    size--;
                } else if (first == '[' && c == ']') {
                    size--;
                } else {
                    stack[size++] = c;
                }
            }
        }
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid(""));
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("{}"));
        System.out.println(new Solution().isValid("[]"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("[{()}]"));
    }
}
