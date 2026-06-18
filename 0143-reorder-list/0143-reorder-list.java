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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head, prev = null;
        //find the half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // isolate
        prev.next = null;
        //reverse
        slow = reverse(slow);

        // merge
        fast = head;
        while (slow != null && fast != null) {
            prev = slow;
            ListNode fastNext = fast.next;
            ListNode slowNext = slow.next;
            fast.next = slow;
            slow.next = fastNext;
            slow = slowNext;
            fast = fastNext;
        }
        if (slow != null)
            prev.next = slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, next = null, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}