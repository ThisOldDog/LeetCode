import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
class Solution {
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

    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> l = new ArrayList<>(1024);
        ListNode n = head;
        while (n != null) {
            l.add(n);
            n = n.next;
        }
        int half = l.size() >> 1;
        for (int i = 1; i <= half; i++) {
            int ci = l.size() - i, p = i - 1, c = i;
            l.get(p).next = l.get(ci);
            l.get(ci).next = l.get(c);
        }
        l.get(half).next = null;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
//        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
//        h.next.next.next.next = new ListNode(5);
        new Solution().reorderList(h);
    }
}