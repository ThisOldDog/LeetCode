/**
 * @author 废柴 2020/9/30 15:57
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        append(root, val);
        return root;
    }

    private void append(TreeNode root, int val) {
        if (root.val > val)
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                append(root.left, val);
        if (root.val < val)
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                append(root.right, val);
    }
}
