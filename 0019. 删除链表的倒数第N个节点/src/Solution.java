import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>(1024);
        ListNode i = head;
        while (i != null) {
            list.add(i);
            i = i.next;
        }
        ListNode r = list.get(list.size() - n);
        int parent = list.size() - n - 1;
        int child = list.size() - n + 1;
        if (parent >= 0 && child < list.size()) {
            list.get(parent).next = list.get(child);
        } else if (parent < 0 && child == list.size()) {
            return null;
        } else if (child == list.size()) {
            list.get(parent).next = null;
        } else {
            return list.get(child);
        }
        return list.get(0);
    }
}