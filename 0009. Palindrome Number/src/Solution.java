/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        int t = x;
        int reverse = 0;
        while (t > 0) {
            reverse = reverse * 10 + t % 10;
            t /= 10;
        }
        return x == reverse;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(110));
        System.out.println(Integer.reverseBytes(110));
    }
}
