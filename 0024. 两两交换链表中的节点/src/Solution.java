/**
 * @author 废柴 2020/10/13 15:54
 */
public class Solution {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode p1 = head, p2 = p1 == null ? null : p1.next;
        while (p1 != null && p2 != null) {
            p1.val += p2.val;
            p2.val = p1.val - p2.val;
            p1.val -= p2.val;
            p1 = p2.next;
            p2 = p1.next;
        }
        return head;
    }
}
