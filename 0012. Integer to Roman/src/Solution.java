/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public static String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public static int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public static int startIndex = value.length - 1;

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int j = startIndex; j >= 0; j--) {
            int bit = num / value[j];
            if (bit == 0) {
                continue;
            }
            while (bit-- > 0) {
                sb.append(symbol[j]);
            }
            num %= value[j];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
