/**
 * @author 废柴 2020/11/8 14:59
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int sum = 0, b = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < b) {
                b = price;
            } else if (price > b) {
                sum += (price - b);
                b = price;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
    }
}
