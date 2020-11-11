import java.util.ArrayDeque;

/**
 * @author 废柴 2020/9/28 15:05
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

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(new ArrayDeque<Node>(1000) {{
            add(root);
        }});
        return root;
    }

    private void connect(ArrayDeque<Node> queue) {
        int size = queue.size();
        if (size > 0) {
            while (size-- > 0) {
                Node node = queue.pollFirst();
                node.next = size == 0 ? null: queue.peekFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            connect(queue);
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        new Solution().connect(node);
    }
}
