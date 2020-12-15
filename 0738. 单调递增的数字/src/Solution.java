/**
 * @author 废柴 2020/12/15 20:34
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        return makeMonotonicallyIncreasing(N);
    }

    private int makeMonotonicallyIncreasing(int n) {
        int[] ns = new int[32];
        int i = 0;
        while (n > 0) {
            ns[i++] = n % 10;
            n /= 10;
        }
        for (int j = 1; j < i; j++) {
            if (ns[j] > ns[j - 1]){
                for (int k = 0; k < j; k++) {
                    ns[k] = 9;
                }
                ns[j] -= 1;
            }
        }
        int nn = 0, k = 1;
        for (int j = 0; j < i; j++) {
            nn += (ns[j] * k);
            k *= 10;
        }
        return nn;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(1234));
    }
}
