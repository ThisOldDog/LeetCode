/**
 * @author 废柴 2020/9/23 20:52
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            return merge(l1, l2);
        } else {
            return merge(l2, l1);
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = l1, p = l1;
        l1 = l1.next;
        if (l1 == null) {
            p.next = l2;
            return head;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p = l1;
                l1 = l1.next;
                if (l1 == null) {
                    p.next = l2;
                    break;
                }
            } else {
                p.next = l2;
                while (l2 != null && l1.val > l2.val) {
                    p = l2;
                    l2 = l2.next;
                }
                p.next = l1;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        l1.next = new ListNode(-10);
        l1.next.next = new ListNode(-9);
        l1.next.next.next = new ListNode(-4);
        ListNode l2 = new ListNode(-7);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        ListNode l3 = new Solution().mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
