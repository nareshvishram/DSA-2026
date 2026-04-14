class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 1) Find middle (first half will be longer or equal)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);

        // 2) Split AFTER slow
        ListNode second = slow.next;
        slow.next = null;

        // 3) Reverse second half
        second = reverse(second);

        // 4) Merge alternately (second drives)
        ListNode first = head;
        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
