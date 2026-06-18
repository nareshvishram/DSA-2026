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
    ListNode res = null, tmp = null;

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            boolean flag=false;
            while (ptr != null && ptr.next != null && ptr.val == ptr.next.val){
                ptr = ptr.next;
                flag=true;
            }
            if(!flag)
                insert(ptr);
            ptr = ptr.next;
        }
        return res;
    }

    private void insert(ListNode ptr) {
        if (res == null) {
            res = new ListNode(ptr.val);
            tmp = res;
        } else {
            tmp.next = new ListNode(ptr.val);
            tmp = tmp.next;
        }
    }
}