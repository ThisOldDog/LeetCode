/**
 * @author 废柴 2020/10/4 20:24
 */
public class Solution {
    public int minimumOperations(String leaves) {
        char[] leave = leaves.toCharArray();
        int[][] f = new int[leave.length][3];
        // 0 - 左侧红色, 1 - 中间黄色, 2 - 右侧黄色
        f[0][0] = leave[0] == 'r' ? 0 : 1;
        f[0][1] = f[0][2] = Integer.MAX_VALUE >> 1;
        for (int i = 1; i < leave.length; i++) {
            int r = leave[i] == 'r' ? 0 : 1, y = leave[i] == 'y' ? 0 : 1;
            f[i][0] = f[i - 1][0] + r;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + y;
            f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + r;
        }
        return f[leave.length - 1][2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("ryr"));            // 0
        System.out.println(new Solution().minimumOperations("rrryyyrryyyrr"));  // 2
        System.out.println(new Solution().minimumOperations("yrr"));            // 2
        System.out.println(new Solution().minimumOperations("yrry"));           // 3
        System.out.println(new Solution().minimumOperations("yry"));            // 3
        System.out.println(new Solution().minimumOperations("ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy"));            // 41
        System.out.println(new SolutionTimeOut().minimumOperations("ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry"));            // 39
    }
}
