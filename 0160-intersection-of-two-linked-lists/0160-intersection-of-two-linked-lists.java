/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA, curr2 = headB;
        while (true) {
            if (curr1 == curr2)
                return curr1;
            curr1 = curr1 == null ? headB : curr1.next;
            curr2 = curr2 == null ? headA : curr2.next;
        }

    }
}