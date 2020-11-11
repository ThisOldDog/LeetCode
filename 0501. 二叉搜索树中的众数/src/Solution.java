import java.util.*;

/**
 * @author 废柴 2020/9/24 19:26
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> result;
        findMode(root, result = new ArrayList<>(), new int[]{0}, new HashSet<>());
        int[] ra = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ra[i] = result.get(i);
        }
        return ra;
    }

    private void findMode(TreeNode node, List<Integer> result, int[] maxCnt, Set<Integer> cache) {
        if (node == null) {
            return;
        }
        if (!cache.contains(node.val)) {
            int[] cnt;
            findEquals(node.left, node.val, cnt = new int[]{1});
            findEquals(node.right, node.val, cnt);
            if (cnt[0] > maxCnt[0]) {
                result.clear();
            }
            if (cnt[0] >= maxCnt[0]) {
                result.add(node.val);
                maxCnt[0] = cnt[0];
            }
            cache.add(node.val);
        }
        findMode(node.left, result, maxCnt, cache);
        findMode(node.right, result, maxCnt, cache);
    }

    private void findEquals(TreeNode node, int value, int[] cnt) {
        if (node == null) {
            return;
        }
        if (node.val == value) {
            cnt[0] += 1;
            findEquals(node.left, value, cnt);
            findEquals(node.right, value, cnt);
        } else if (node.val < value) {
            findEquals(node.right, value, cnt);
        } else {
            findEquals(node.left, value, cnt);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(41);
        treeNode.left = new TreeNode(37);
        treeNode.left.left = new TreeNode(24);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.left.left.left.right = new TreeNode(2);
        treeNode.left.left.left.right.right = new TreeNode(24);
        treeNode.left.right = new TreeNode(39);
        System.out.println(Arrays.toString(new Solution().findMode(treeNode)));
    }
}
