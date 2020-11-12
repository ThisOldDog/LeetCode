/**
 * @author 废柴 2020/11/12 9:11
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] r = new int[A.length];
        int even = 0, odd = 1;
        for (int a : A) {
            if ((a & 1) == 1) {
                r[odd] = a;
                odd += 2;
            } else {
                r[even] = a;
                even += 2;
            }
        }
        return r;
    }
}
