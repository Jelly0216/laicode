package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.pollFirst();
    }

    public Integer pollLast() {
        move(right, left);
        return right.isEmpty() ? null : right.pollFirst();
    }

    public Integer peekFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.peekFirst();
    }

    public Integer peekLast() {
        move(right, left);
        return right.isEmpty() ? null : right.peekFirst();
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    private void move(Deque<Integer> one, Deque<Integer> two) {
        if (!two.isEmpty()) {
            return;
        }

        int halfSize = one.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            buffer.offerFirst(one.pollFirst());
            while (!one.isEmpty()) {
                two.offerFirst(one.pollFirst());
            }
            while (!buffer.isEmpty()) {
                one.offerFirst(buffer.pollFirst());
            }
        }
    }

}
