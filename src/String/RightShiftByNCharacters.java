package String;

public class Solution {
    public String rightShift(String input, int n) {
        // Write your solution here
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int num = n % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, num - 1);
        reverse(array, num, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}