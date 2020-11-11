import java.util.List;

/**
 * @author 废柴 2020/9/18 16:10
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        for (ListNode parent = null, node = head; node != null; node = node.next) {
            if (node.val == val) {
                if (parent == null) {
                    head = node.next;
                } else {
                    parent.next = node.next;
                }
            } else {
                parent = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        new Solution().removeElements(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
