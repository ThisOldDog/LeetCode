/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution02 {

    public static int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(reverse(-10));
    }
}
