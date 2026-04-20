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
    ListNode tmp = null, root = null;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1, ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                insert(ptr1);
                ptr1 = ptr1.next;
            } else {
                insert(ptr2);
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != null) {
            insert(ptr1);
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            insert(ptr2);
            ptr2 = ptr2.next;
        }
        return root;
    }

    private void insert(ListNode ptr) {
        if (root == null) {
            root = new ListNode(ptr.val);
            tmp = root;
        } else {
            tmp.next = new ListNode(ptr.val);
            tmp = tmp.next;
        }
    }
}