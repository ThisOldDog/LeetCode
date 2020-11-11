/**
 * 计算 Z 图形中每一个字符的坐标
 *
 * @author qingsheng.chen@hand-china.com
 */
public class Solution02 {

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        final int v = (numRows << 1) - 2, range = numRows << 1;
        for (int i = 1; i <= numRows; ++i) {
            int maxCnt = (int) Math.ceil(chars.length * 1.0 / v);
            for (int j = 0; j < maxCnt; j++) {
                int index1 = j * v + i - 1;
                if ((i == 1 || i == numRows) && index1 < chars.length) {
                    sb.append(chars[index1]);
                } else if (i < numRows && index1 < chars.length) {
                    sb.append(chars[index1]);
                    int index2 = j * v + (range - i) - 1;
                    if (index2 < chars.length) {
                        sb.append(chars[index2]);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(convert("123456789", 2));
    }
}
