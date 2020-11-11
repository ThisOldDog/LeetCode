import java.util.ArrayDeque;

/**
 * @author 废柴 2020/10/15 10:28
 */
public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node previous = queue.pollFirst();
            if (previous.left != null) {
                queue.addLast(previous.left);
            }
            if (previous.right != null) {
                queue.addLast(previous.right);
            }
            while (size > 1) {
                size--;
                Node next = queue.pollFirst();
                previous.next = next;
                previous = next;
                if (previous.left != null) {
                    queue.addLast(previous.left);
                }
                if (previous.right != null) {
                    queue.addLast(previous.right);
                }
            }
        }
        return root;
    }
}
