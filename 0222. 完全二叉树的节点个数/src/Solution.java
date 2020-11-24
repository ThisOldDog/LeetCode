/**
 * @author 废柴 2020/11/24 17:25
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

    public int countNodes(TreeNode root) {
        int[] cnt = {0};
        countNodes(root, cnt);
        return cnt[0];
    }

    private void countNodes(TreeNode root, int[] cnt) {
        if (root != null) {
            cnt[0] += 1;
            countNodes(root.left, cnt);
            countNodes(root.right, cnt);
        }
    }
}
