/**
 * @author 废柴 2020/9/28 19:44
 * 100000000 : 32896342
 * 999 : 504
 */
public class Solution {
    public int lastRemaining(int n) {
        int start = 1, end = n, step = 1, mod = 0;
        while (start != end) {
            if (mod == 0) {
                // 奇数个数
                if ((((end - start) / step + 1) & 1) == 1) {
                    end -= step;
                }
                start += step;
            } else {
                // 奇数个数
                if ((((end - start) / step + 1) & 1) == 1) {
                    start += step;
                }
                end -= step;
            }
            step <<= 1;
            mod = (mod + 1) & 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(9));
        System.out.println(new Solution().lastRemaining(100000000));
        System.out.println(new Solution().lastRemaining(999));
    }
}
