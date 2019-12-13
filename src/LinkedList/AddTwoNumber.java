package LinkedList;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int result = 0;
        while (l1 != null || l2 != null || result != 0) {
            if (l1 != null) {
                result += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.value;
                l2 = l2.next;
            }
            curr.next = new ListNode(result %10);
            result = result / 10;
            curr = curr.next;
        }
        return dummy.next;
    }
}
