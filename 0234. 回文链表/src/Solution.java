/**
 * @author 废柴 2020/10/23 9:11
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode q = head, s = head;
        if (q == null || q.next == null) {
            return true;
        }
        // 找到中心点
        while (q != null) {
            q = q.next;
            if (q != null) {
                q = q.next;
            }
            s = s.next;
        }
        // S为中心点，反转后半段
        ListNode p = s, c = s.next, n;
        p.next = null;
        while (c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        // 从头开始对比
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
//        h.next.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(h));
    }
}