package BfsDfs;

import java.util.List;

public class Solution {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, res);
        return res;
    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(n, l + 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > r) {
            sb.append(')');
            helper(n, l, r + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
