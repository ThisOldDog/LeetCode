/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public static int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public static int startIndex = value.length - 1;

    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            for (int j = startIndex; j >= 0; j--) {
                if (s.startsWith(symbol[j], i)) {
                    ans += value[j];
                    i += symbol[j].length();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
