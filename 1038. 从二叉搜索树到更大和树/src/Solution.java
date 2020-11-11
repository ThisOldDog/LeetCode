/**
 * @author 废柴 2020/9/21 16:46
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

    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, new int[1]);
        return root;
    }

    private void bstToGst(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        bstToGst(node.right, sum);
        node.val += sum[0];
        sum[0] = node.val;
        bstToGst(node.left, sum);
    }

    public static void main(String[] args) {

    }
}
