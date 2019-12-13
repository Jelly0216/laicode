package Tree;

public class Solution {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
            res.add(curr.key);
        }
        return res;
    }
}