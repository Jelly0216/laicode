package BfsDfs;

public class Solution {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (input == null) {
            return res;
        }
        char[] array = input.toCharArray();
        helper(array, 0, res);
        return res;
        // Write your solution here
    }

    private void helper(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, res);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
}
