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
    private ListNode head;
    private ListNode curr;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, num = 0;

        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + carry;
            carry = num / 10;
            //System.out.println(num);
            ListNode currNode = new ListNode(num % 10);
            insert(currNode);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            num = l1.val + carry;
            carry = num / 10;
            insert(new ListNode(num % 10));
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + carry;
            carry = num / 10;
            insert(new ListNode(num % 10));
            l2 = l2.next;
        }
        if (carry != 0)
            insert(new ListNode(carry));
        return head;
    }

    private void insert(ListNode node) {
        if (head == null) {
            head = node;
            curr = head;
        } else {
            curr.next = node;
            curr = curr.next;
        }
    }
}