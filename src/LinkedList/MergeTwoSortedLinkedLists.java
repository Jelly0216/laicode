package LinkedList;

public class Solution {
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                curr.next = one;
                one = one.next;
            }
            else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        if (one != null) {
            curr.next = one;
        }
        else {
            curr.next =two;
        }
        return dummy.next;
    }
}
