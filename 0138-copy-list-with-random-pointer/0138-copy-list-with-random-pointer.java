/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node ptr = head;
        while (ptr != null) {
            Node nn = new Node(ptr.val);
            Node next = ptr.next;
            ptr.next = nn;
            nn.next = next;
            ptr = next;
        }
        ptr = head;
        while (ptr != null) {
            if (ptr.next != null && ptr.random != null)
                ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }
        ptr = head;
        Node res = ptr.next;
        while (ptr != null && ptr.next != null) {
            Node next = ptr.next;
            ptr.next = next.next;
            if (ptr.next != null)
                next.next = ptr.next.next;
            ptr = ptr.next;
        }
        return res;
    }
}