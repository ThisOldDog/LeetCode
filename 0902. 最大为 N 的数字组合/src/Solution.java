import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 废柴 2020/9/4 16:26
 */
public class Solution {
    private static int MAX_ORIGIN = Integer.MAX_VALUE / 10;

    public static int atMostNGivenDigitSet(String[] digits, int n) {
       return atMostNGivenDigitSet(digits, n, new AtomicInteger(), 0);
    }

    private static int atMostNGivenDigitSet(String[] digits, int n, AtomicInteger cnt, int value) {
        for (int j = 0; j < digits.length; j++) {
            int append = (digits[j].charAt(0) - '0');
            if (value >= MAX_ORIGIN) {
                return cnt.get();
            }
            int add = value * 10 + append;
            if (add < n) {
                cnt.addAndGet(1);
                atMostNGivenDigitSet(digits, n, cnt, add);
            }
        }
        return cnt.get();
    }

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"3", "4", "9"}, 4));
    }
}
