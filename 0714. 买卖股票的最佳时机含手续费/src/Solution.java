/**
 * @author 废柴 2020/12/17 9:50
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tdp0 = Math.max(dp0, dp1 + prices[i] - fee);
            int tdp1 = Math.max(dp0 - prices[i], dp1);
            dp0 = tdp0;
            dp1= tdp1;
        }
        return dp0;
    }
}
