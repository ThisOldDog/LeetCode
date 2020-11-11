import java.util.Arrays;

/**
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题解：
 * 需要删除线的情况共有三种：
 * 1. 存在结点拥有两个父节点
 * 1.1 此结点成环，删除父节点在环中的线段
 * 1.2 此结点不成环，任一删除一条
 * 2. 不存在结点拥有两个父节点，并且无根结点
 * 2.1 删除环中的任一条线段
 * @author 废柴 2020/9/17 17:01
 */
public class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        boolean[] parent = new boolean[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];
        int multiParent = 0;
        for (int[] edge : edges) {
            // 同一个结点有用两个父节点，删除后面的一个
            if (parent[edge[1]]) {
                multiParent = edge[1];
            }
            parent[edge[1]] = true;
            map[edge[0]][edge[1]] = true;
        }
        if (multiParent != 0) {
            // 如果右节点有多个父结点，查询当前结点是否在环中
            int[] range = new int[n + 1];
            // 如果是环则移除换中的线
            if (isRange(map, multiParent, range)) {
                boolean[][] rangeMap = new boolean[n + 1][n + 1];
                for (int k = 0; k < range.length && range[k] != 0; k++) {
                    rangeMap[range[k]][range[k + 1]] = true;
                }
                for (int i = edges.length - 1; i < edges.length; i--) {
                    if (edges[i][1] == multiParent && rangeMap[edges[i][0]][multiParent]) {
                        return edges[i];
                    }
                }
                return null;
            }
            // 如果不是环，则移除任一
            for (int i = edges.length - 1; i < edges.length; i--) {
                if (edges[i][1] == multiParent) {
                    return edges[i];
                }
            }
        } else {
            // 如果没有多个父节点，说明有环
            int[] range = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                // 找到环了
                if (isRange(map, i, range)) {
                    boolean[][] rangeMap = new boolean[n + 1][n + 1];
                    for (int k = 0; k < range.length && range[k] != 0; k++) {
                        rangeMap[range[k]][range[k + 1]] = true;
                    }
                    for (int j = edges.length - 1; j >= 0; j--) {
                        // 环中的结点
                        if (rangeMap[edges[j][0]][edges[j][1]]) {
                            // 左结点的父亲结点也在环中
                            for (int k = 1; k < rangeMap.length; k++) {
                                if (rangeMap[k][edges[j][0]]) {
                                    return edges[j];
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        return null;
    }

    private boolean isRange(boolean[][] map, int source, int[] range) {
        boolean[] findTarget = new boolean[]{false};
        range[0] = source;
        for (int i = 1; i < map[source].length; i++) {
            if (map[source][i] && !findTarget[0]) {
                range[1] = i;
                isRange(map, i, range, findTarget, 2);
                if (findTarget[0]) {
                    break;
                }
            }
        }
        return findTarget[0];
    }

    private void isRange(boolean[][] map, int source, int[] range, boolean[] findTarget, int index) {
        if (findTarget[0]) {
            return;
        }
        if (source == range[0]) {
            findTarget[0] = true;
            for (int i = index + 1; i < range.length && range[i] != 0; i++) {
                range[i] = 0;
            }
        } else {
            for (int i = 1; i < map[source].length; ++i) {
                if (map[source][i] && !findTarget[0]) {
                    range[index] = i;
                    isRange(map, i, range, findTarget, index + 1);
                    if (findTarget[0]) {
                        return;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{
                {2, 1},
                {3, 1},
                {4, 2},
                {1, 4}
        })));
    }
}
