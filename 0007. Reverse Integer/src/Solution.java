import java.math.BigDecimal;

/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static final java.math.BigDecimal MAX = java.math.BigDecimal.valueOf(Integer.MAX_VALUE);
    public static final java.math.BigDecimal MIN = java.math.BigDecimal.valueOf(Integer.MIN_VALUE);

    public static int reverse(int x) {
        String str = String.format("%+d", x);
        java.math.BigDecimal result = new java.math.BigDecimal(str.substring(0, 1) + new StringBuilder(str.substring(1)).reverse().toString());
        if (result.compareTo(MIN) < 0) {
            return 0;
        } else if (result.compareTo(MAX) > 0) {
            return 0;
        } else {
            return result.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
