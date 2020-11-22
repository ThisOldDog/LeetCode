import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 废柴 2020/11/22 15:37
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

    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        List<ListNode> listNodes = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            listNodes.add(h);
            h = h.next;
        }
        listNodes.sort(Comparator.comparingInt(e -> e.val));
        head = listNodes.get(0);
        h = head;
        for (int i = 1; i < listNodes.size(); i++) {
            h.next = listNodes.get(i);
            h = h.next;
        }
        h.next = null;
        return head;
    }
}
