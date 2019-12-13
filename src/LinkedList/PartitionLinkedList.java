package LinkedList;

public class Solution {
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyLarger = new ListNode(0);
        ListNode dummySmaller = new ListNode(0);
        ListNode larger = dummyLarger;
        ListNode smaller = dummySmaller;
        while (head != null) {
            if (head.value < target) {
                smaller.next = head;
                smaller = smaller.next;
            }
            else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        smaller.next = dummyLarger.next;
        larger.next = null;
        return dummySmaller.next;
    }
}
