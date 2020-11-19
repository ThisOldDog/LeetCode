/**
 * @author 废柴 2020/11/19 19:32
 */
public class Solution {
    public int canCompleteCircuit(int[] gas /* 获得 */, int[] cost /* 去下一站的花费 */) {
        int s = 0, c = s, g = 0, cnt = 0;
        while (cnt < 2) {
            if (c == s) {
                cnt++;
            }
            g = g + gas[c] - cost[c];
            while (g < 0) {
                s = prev(s, gas.length);
                g = g + gas[s] - cost[s];
                if (g < 0 && s == c) {
                    return -1;
                }
            }
            c = next(c, gas.length);
        }
        return s;
    }

    private int prev(int n, int m) {
        return (m + (n - 1)) % m;
    }

    private int next(int n, int m) {
        return (n + 1) % m;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1}));
    }
}
