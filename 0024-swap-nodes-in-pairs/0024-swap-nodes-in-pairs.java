/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ptr = head, prev = null, res = null;
        if (head == null || head.next == null)
            return head;
        while (ptr != null && ptr.next != null) {
            ListNode next = ptr.next;
            if (res == null)
                res = next;
            ListNode nextToNext = next.next;
            ListNode tmp = ptr;
            next.next = ptr;
            ptr.next = nextToNext;
            if (prev != null)
                prev.next = next;
            prev = ptr;
            ptr = nextToNext;
        }
        return res;
    }
}