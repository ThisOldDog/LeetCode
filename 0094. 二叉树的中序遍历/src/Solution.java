import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
        return result;
    }
}