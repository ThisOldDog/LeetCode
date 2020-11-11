/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static int myAtoi(String str) {
        long ans = 0;
        char[] chars = str.toCharArray();
        boolean started = false;
        Boolean positive = null;
        for (char aChar : chars) {
            if (!started && ' ' == aChar) {
                continue;
            }
            started = true;
            if (positive == null && aChar == '-') {
                positive = false;
                continue;
            }
            if (positive == null && aChar == '+') {
                positive = true;
                continue;
            }
            if (positive == null && aChar >= '0' && aChar <= '9') {
                positive = true;
            }
            if (positive != null && aChar >= '0' && aChar <= '9') {
                ans = ans * 10 + (aChar - '0');
                if (positive == Boolean.TRUE && ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (positive == Boolean.FALSE && ans * -1 < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break;
        }
        if (positive == Boolean.FALSE) {
            return (int) (ans * -1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
