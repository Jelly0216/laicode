public class Solution {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public Solution() {
        // write your solution here
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return - 1;
        }
        int res = stack.pollFirst();
        if (res == minStack.peekFirst()) {
            minStack.pollFirst();
        }
        return res;
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (minStack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }
}