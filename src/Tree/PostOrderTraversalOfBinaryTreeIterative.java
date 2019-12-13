package Tree;

public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                }
                else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                }
                else {
                    stack.pollFirst();
                    res.add(curr.key);
                }
            }
            else if(curr.left == prev) {
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                }
                else {
                    res.add(curr.key);
                    stack.pollFirst();
                }
            }
            else {
                res.add(curr.key);
                stack.pollFirst();
            }
            prev = curr;
        }
        return res;
    }
}
