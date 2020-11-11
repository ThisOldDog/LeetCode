import java.util.StringJoiner;

/**
 * @author 废柴 2020/10/10 9:53
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .toString();
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            } else {
                return null;
            }
            if (p1 == p2) {
                ListNode p3 = head;
                while (p3 != p1) {
                    p3 = p3.next;
                    p1 = p1.next;
                }
                return p3;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(new Solution().detectCycle(head));
    }
}
