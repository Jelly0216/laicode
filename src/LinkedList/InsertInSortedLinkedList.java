package LinkedList;

public class Solution {
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        ListNode newNode = new ListNode(value);
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        ListNode prev = head;
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
}