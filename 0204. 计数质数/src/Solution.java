/**
 * @author 废柴 2020/12/3 19:59
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                cnt++;
                for (int j = i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return cnt;
    }
}
