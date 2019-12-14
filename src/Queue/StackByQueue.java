class Solution {
    Queue<Integer> q1;
    Queue<Integer> q2;
    Integer myTop;
    /** Initialize your data structure here. */
    public Solution() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        myTop = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer res = null;
        if (q1.isEmpty()) {
            return res;
        }
        while (!q1.isEmpty()) {
            res = q1.poll();
            if (!q1.isEmpty()) {
                q2.offer(res);
                myTop = res;
            }
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return res;
    }

    /** Get the top element. */
    public Integer top() {
        if (q1.isEmpty()) {
            return null;
        }
        return myTop;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}