import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        int[] path = new int[128];
        binaryTreePaths(root, result, path, 0);
        return result;
    }

    public void binaryTreePaths(TreeNode node, List<String> result, int[] path, int i) {
        if (node == null)
            return;
        if (i >= path.length)
            path = java.util.Arrays.copyOf(path, Math.min(path.length << 1, Integer.MAX_VALUE));
        path[i] = node.val;
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                sb.append(path[j]);
                if (j < i) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            return;
        }
        binaryTreePaths(node.left, result, path, i + 1);
        binaryTreePaths(node.right, result, path, i + 1);
    }
}