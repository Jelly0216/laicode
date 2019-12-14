public class Solution {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        sort(s1, s2);
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2) {
        while (!s1.isEmpty()) {
            int currMin = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                int curr = s1.pollFirst();
                if (curr < currMin) {
                    currMin = curr;
                    count = 1;
                }
                else if (curr == currMin) {
                    count++;
                }
                s2.offerFirst(curr);
            }

            while (!s2.isEmpty() && s2.peekFirst() >= currMin) {
                int temp = s2.pollFirst();
                if (temp != currMin) {
                    s1.offerFirst(temp);
                }
            }

            while (count > 0) {
                s2.offerFirst(currMin);
                count--;
            }
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }

    }
}