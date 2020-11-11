/**
 * 计算 Z 图形中每一个字符的坐标
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        // 一个 Z 的字符数
        int charNumber = (numRows << 1) - 2;
        // 字符一共可以画 Z 的数量
        int zCnt = s.length() / charNumber + 1, maxY = 0;
        // 画板
        char[][] zPanel = new char[numRows + 1][zCnt * (numRows - 1) + 1];
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            int y = getY(charNumber, numRows, i);
            maxY = Math.max(y, maxY);
            zPanel[getX(charNumber, numRows, i)][y] = chars[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < zPanel.length; i++) {
            for (int j = 1; j < maxY + 1; j++) {
                sb.append(zPanel[i][j] != 0 ? zPanel[i][j] : "");
            }
        }
        return sb.toString();
    }

    public static int getY(int zCharNumber, int zWidth, int i) {
        int base = i / zCharNumber * (zWidth - 1);
        i = i % zCharNumber;
        if (i == 0) {
            return base;
        } else if (i <= zWidth) {
            return base + 1;
        } else {
            return base + 1 + (i - zWidth);
        }
    }

    public static int getX(int zCharNumber, int zWidth, int i) {
        i = i % zCharNumber;
        if (i == 0) {
            return 2;
        }else if (i <= zWidth) {
            return i;
        } else {
            return (zWidth << 1) - i;
        }
    }

    public static void main(String[] args) {
        System.out.print(convert("ABC", 2));
    }
}
