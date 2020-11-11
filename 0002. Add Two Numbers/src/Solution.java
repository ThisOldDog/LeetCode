/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (next == null ? "." : (" -> " + next.toString()));
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode previous = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int result = n1 + n2 + carry;
            if (sum == null) {
                sum = new ListNode(result % 10);
                previous = sum;
            } else {
                previous.next = new ListNode(result % 10);
                previous = previous.next;
            }
            carry = result / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
