package LinkedList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        while (head == null || head.next == null) {
            return true;
        }
        ListNode middle = getMid(head);
        ListNode middleNext = middle.next;
        ListNode newHead = reverse(middleNext);
        while (newHead != null) {
            if (head.value != newHead.value) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}