package BfsDfs;

public class Solution {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        char[] input = set.toCharArray();
        helper(input, sb, 0, res);
        return res;
    }

    private void helper(char[] input, StringBuilder sb, int index, List<String> res) {
        if (index == input.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(input[index]);
        helper(input, sb, index + 1, res);
        sb.deleteCharAt(sb.length() - 1);
        helper(input, sb, index + 1, res);
    }
}