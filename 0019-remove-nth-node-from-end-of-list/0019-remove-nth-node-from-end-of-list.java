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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1=head,ptr2=head;
        while(n-->0)
            ptr1=ptr1.next;
        if(ptr1==null)
            return head.next;
        while(ptr1!=null && ptr1.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        ptr2.next=ptr2.next.next;
        return head;
    }
}