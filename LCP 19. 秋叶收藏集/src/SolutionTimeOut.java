/**
 * @author 废柴 2020/10/4 17:28
 */
public class SolutionTimeOut {
    public int minimumOperations(String leaves) {
        char[] leave = leaves.toCharArray();
        int[] min = new int[]{Integer.MAX_VALUE};
        minimumOperations(leave, 0, 0, false, false, min);
        return min[0];
    }

    private void minimumOperations(char[] leave, int i, int cnt, boolean ly /* 左侧是否有黄色 */, boolean yr /* 黄色之后是否有红色*/, int[] min) {
        if (i == leave.length) {
            // 左侧无黄色，则需要变任一一个
            if (!ly) {
                cnt++;
            }
            if (min[0] > cnt) {
                min[0] = cnt;
            }
//            System.out.println(new String(leave) + " : " + cnt);
            return;
        }
        // 两端
        if (i == 0 || i == leave.length - 1) {
            // 两端为黄色，则必定要变色
            if (leave[i] == 'y') {
                leave[i] = 'r';
                minimumOperations(leave, i + 1, cnt + 1, ly, yr, min);
                leave[i] = 'y';
            } else {
                // 两端为红色，必定不变色
                minimumOperations(leave, i + 1, cnt, ly, yr, min);
            }
        } else {
            // 中间结点
            if (leave[i] == 'r') {
                // 红色叶子
                if (!ly) {
                    // 左侧无黄色，直接遍历后续结点
                    minimumOperations(leave, i + 1, cnt, false, false, min);
                    // 或者尝试变色
//                    leave[i] = 'y';
//                    minimumOperations(leave, i + 1, cnt + 1, true, false, min);
//                    leave[i] = 'r';
                } else {
                    // 左侧有黄色
                    if (yr) {
                        // 如果左侧的黄色后有红色，无法变色
                        minimumOperations(leave, i + 1, cnt, true, true, min);
                    } else {
                        // 如果左侧的黄色后无红色
                        // 作为有红色，开始遍历
                        minimumOperations(leave, i + 1, cnt, true, true, min);
                        // 变色
                        // 左侧有黄则必须变色或者尝试变色
                        leave[i] = 'y';
                        minimumOperations(leave, i + 1, cnt + 1, true, false, min);
                        leave[i] = 'r';
                    }
                }
            } else {
                // 黄色叶子
                if (yr) {
                    // 如果左侧的黄色后已经有红色，则必须变色
                    leave[i] = 'r';
                    minimumOperations(leave, i + 1, cnt + 1, true, true, min);
                    leave[i] = 'y';
                } else {
                    // 左侧有黄色
                    if (ly) {
                        // 作为黄色继续遍历
                        minimumOperations(leave, i + 1, cnt, true, false, min);
                        // 或者变色为红色
                        leave[i] = 'r';
                        minimumOperations(leave, i + 1, cnt + 1, true, true, min);
                        leave[i] = 'y';
                    } else {
                        minimumOperations(leave, i + 1, cnt, true, false, min);
                        // 左侧无黄色，变为红色
                        leave[i] = 'r';
                        minimumOperations(leave, i + 1, cnt + 1, false, false, min);
                        leave[i] = 'y';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minimumOperations("ryr"));            // 0
//        System.out.println(new Solution().minimumOperations("rrryyyrryyyrr"));  // 2
//        System.out.println(new Solution().minimumOperations("yrr"));            // 2
//        System.out.println(new Solution().minimumOperations("yrry"));           // 3
//        System.out.println(new Solution().minimumOperations("yry"));            // 3
//        System.out.println(new Solution().minimumOperations("ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy"));            // 41
        System.out.println(new SolutionTimeOut().minimumOperations("ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry"));            // 39
    }
    // ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry
    // rrrrrrrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyrrrrrrrrrrrrrrrrrrrrrr
}
