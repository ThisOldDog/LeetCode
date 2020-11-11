import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 废柴 2020/9/25 16:16
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int si, int ei, int[] postorder, int sp, int ep) {
        if (si > ei || sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[ep]);
        // 1. 获取根在中序遍历中的位置
        int ri = si;
        HashSet<Integer> left = new HashSet<>();
        for (; ri < ei; ++ri) {
            if (inorder[ri] == postorder[ep]) {
                break;
            }
            left.add(inorder[ri]);
        }
        // 2. 获取右子树在后序遍历中的开始位置
        int rs = sp + ri - si;
        // 3 如果根节点 不等于 中序遍历的起始结点 -> 有左子树
        root.left = buildTree(inorder, si, ri - 1, postorder, sp, rs - 1);
        // 4. 如果右节点的起始结点不等于尾结点 -> 有右子树
        root.right = buildTree(inorder, ri + 1, ei, postorder, rs, ep - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{1, 2, 3, 4}, new int[]{3, 4, 2, 1});
    }
}
