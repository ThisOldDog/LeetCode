/**
 * @author 废柴 2020/9/27 19:13
 */
public class Solution {

    public int minFlips(int a, int b, int c) {
        int[] binA = toBinary(a);
        int[] binB = toBinary(b);
        int[] binC = toBinary(c);
        int min = 0;
        for (int i = 0; i < 32; i++) {
            if (binC[i] == 0) {
                if (binA[i] == 1) {
                    min++;
                }
                if (binB[i] == 1) {
                    min++;
                }
            } else {
                if (binA[i] == 0 && binB[i] == 0) {
                    min++;
                }
            }
        }
        return min;
    }

    private int[] toBinary(int n) {
        int[] bin = new int[32];
        int i = 0;
        while (n != 0) {
            bin[i++] = n & 0B1;
            n = n >> 1;
        }
        return bin;
    }
}
