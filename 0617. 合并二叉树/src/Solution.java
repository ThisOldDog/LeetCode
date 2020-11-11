/**
 * @author 废柴 2020/9/23 10:45
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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        merge(t1, null, t2, null, true);
        return t1;
    }

    private void merge(TreeNode t1, TreeNode t1p, TreeNode t2, TreeNode t2p, boolean left) {
        if (t1 == null && t2 == null) {
            return;
        } else if (t1 == null) {
            if (left) {
                t1p.left = t2;
            } else {
                t1p.right = t2;
            }
        } else if (t2 == null) {
            return;
        } else {
            t1.val += t2.val;
            merge(t1.left, t1, t2.left, t2, true);
            merge(t1.right, t1, t2.right, t2, false);
        }
    }
}
