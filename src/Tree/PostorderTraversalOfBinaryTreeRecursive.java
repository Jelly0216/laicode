package Tree;

public class InorderTraversalOfBinaryTreeRecursive {
    public class Solution {
        public List<Integer> preOrder(TreeNode root) {
            // Write your solution here
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.key);
        }
    }
}
