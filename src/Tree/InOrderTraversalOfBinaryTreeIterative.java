package Tree;

public class Solution {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while (helper != null || !stack.isEmpty()) {
            if (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            }
            else {
                helper = stack.pollFirst();
                res.add(helper.key);
                helper = helper.right;
            }
        }
        return res;
    }
}