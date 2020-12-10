/**
 * @author 废柴 2020/12/10 15:59
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0] += 1;
            } else if (bills[i] == 10) {
                money[1] += 1;
                money[0] -= 1;
                if (money[0] < 0) {
                    return false;
                }
            } else {
                if (money[1] > 0) {
                    money[1] -= 1;
                    money[0] -= 1;
                } else {
                    money[0] -= 3;
                }
                if (money[0] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
