/**
 * @author 废柴 2020/11/13 15:40
 */
public class Solution {
    public static class ListNode {
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

    public ListNode oddEvenList(ListNode head) {
        ListNode h = head, p1 = head, p2, p, p2h;
        if (p1 == null || p1.next == null) {
            return h;
        }
        p2h = p2 = p1.next;
        p = p2.next;
        int mode = 1;
        while (p != null) {
            if (mode == 1){
                p1.next = p;
                p1 = p;
                mode = 0;
            } else {
                p2.next = p;
                p2 = p;
                mode = 1;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = p2h;
        return h;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        new Solution().oddEvenList(h);
    }
}
