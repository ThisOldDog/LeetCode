/**
 * @author 废柴 2020/11/20 9:17
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        for (ListNode n = head.next, p = head; n != null; p = n, n = n.next) {
            if (n.val < p.val) {
                p.next = n.next;
                for (ListNode s = head, sp = null; s != null; sp = s, s = s.next) {
                    if (s.val >= n.val) {
                        if (sp == null) {
                            head = n;
                        } else {
                            sp.next = n;
                        }
                        n.next = s;
                        break;
                    }
                }
                n = p;
            }
        }
        return head;
    }
}
