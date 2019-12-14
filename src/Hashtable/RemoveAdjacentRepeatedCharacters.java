package Hashtable;

public class Solution {
    public String deDup(String input) {
        // Write your solution here
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (fast == 0 || array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return new String(array, 0, slow);
    }
}


public class Solution {
    public String deDup(String input) {
        // Write your solution here
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int fast = 0;
        while (fast < array.length) {
            char currChar = array[fast];
            if (!stack.isEmpty() && stack.peekFirst() == currChar) {
                while (fast < array.length && array[fast] == currChar) {
                    fast++;
                }
                stack.pollFirst();
            }
            else {
                stack.offerFirst(currChar);
                fast++;
            }
        }
        int len = stack.size();
        for (int i = len - 1; i >= 0; i--) {
            array[i] = stack.pollFirst();
        }
        return new String(array, 0, len);
    }
}
