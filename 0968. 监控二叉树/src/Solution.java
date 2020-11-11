/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Status {
        // 覆盖整棵树，并且根结点有摄像头
        int coverAllWithRoot;
        // 覆盖整棵树
        int coverAll;
        // 覆盖左右子树
        int coverLeftAndRight;

        public Status(int coverAllWithRoot, int coverAll, int coverLeftAndRight) {
            this.coverAllWithRoot = coverAllWithRoot;
            this.coverAll = coverAll;
            this.coverLeftAndRight = coverLeftAndRight;
        }
    }

    public int minCameraCover(TreeNode root) {
        return cover(root).coverAll;
    }

    public Status cover(TreeNode root) {
        if (root == null) {
            return new Status(Integer.MAX_VALUE >> 1, 0, 0);
        } else {
            Status ls = cover(root.left);
            Status rs = cover(root.right);
            int coverAllWithRoot = ls.coverLeftAndRight + rs.coverLeftAndRight + 1;
            int coverAll = Math.min(coverAllWithRoot, Math.min(ls.coverAllWithRoot + rs.coverAll, rs.coverAllWithRoot + ls.coverAll));
            int coverLeftAndRight = Math.min(coverAllWithRoot, ls.coverAll + rs.coverAll);
            return new Status(coverAllWithRoot, coverAll, coverLeftAndRight);
        }
    }

    public static void main(String[] args) {
//        2
//        TreeNode treeNode = new TreeNode(0);
//        treeNode.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(0);
//        treeNode.left.right.left = new TreeNode(0);
//        treeNode.left.right.left.right = new TreeNode(0);
//        treeNode.left.right.left.right.left = new TreeNode(0);
//        1
//        TreeNode treeNode = new TreeNode(0);
//        treeNode.left = new TreeNode(0);
//        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(0);
//        1
//        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(0);
        treeNode.right.right = new TreeNode(0);
        treeNode.right.right.right = new TreeNode(0);
        System.out.println(new Solution().minCameraCover(treeNode));
    }

}