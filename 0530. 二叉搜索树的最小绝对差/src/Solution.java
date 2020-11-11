/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        getMinimumDifference(root, new TreeNode[1], min);
        return min[0];
    }

    private void getMinimumDifference(TreeNode node, TreeNode[] previous, int[] min) {
        if (node == null)
            return;
        getMinimumDifference(node.left, previous, min);
        if (previous[0] != null) {
            min[0] = Math.min(min[0], node.val - previous[0].val);
        }
        previous[0] = node;
        getMinimumDifference(node.right, previous, min);
    }
}