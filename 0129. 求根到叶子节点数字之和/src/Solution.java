/**
 * @author 废柴 2020/10/29 19:23
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

    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sumNumbers(root, 0, sum);
        return sum[0];
    }

    private void sumNumbers(TreeNode root, int value, int[] sum) {
        if (root == null) {
            return;
        }
        value *= 10;
        value += root.val;
        if (root.left == null && root.right == null) {
            sum[0] += value;
            return;
        }
        sumNumbers(root.left, value, sum);
        sumNumbers(root.right, value, sum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(treeNode));
    }
}
