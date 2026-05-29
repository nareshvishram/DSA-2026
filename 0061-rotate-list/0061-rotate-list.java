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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)
            return head;
        int len = 0;
        ListNode ptr = head, prev = null;
        while (ptr != null) {
            len++;
            prev = ptr;
            ptr = ptr.next;
        }
        prev.next = head;
        k = len - k % len;
        ptr = head;
        while (k-- > 1) {
            ptr = ptr.next;
        }
        head = ptr.next;
        ptr.next = null;
        return head;
    }
}