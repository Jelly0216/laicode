package LinkedList;

public class MergeSortLinkedList {
    public class Solution {
        public ListNode mergeSort(ListNode head) {
            // Write your solution here
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middle = getMid(head);
            ListNode one = head;
            ListNode two = middle.next;
            middle.next = null;
            ListNode left = mergeSort(one);
            ListNode right = mergeSort(two);
            return merge(left, right);
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

        private ListNode merge(ListNode one, ListNode two) {
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
            else if (two != null) {
                curr.next = two;
            }
            return dummy.next;
        }
    }

}
