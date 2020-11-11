/**
 * @author 废柴 2020/10/9 10:00
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2 && p1 != null) {
                return true;
            }
        }
        return false;
    }
}
