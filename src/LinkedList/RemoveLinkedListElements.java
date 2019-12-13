package LinkedList;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.value == val) {
                prev.next = head.next;
            }
            else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
