package BfsDfs;

public class Solution {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left == null) {
                flag = true;
            }
            else if (flag) {
                return false;
            }
            else {
                q.offer(currNode.left);
            }
            if (currNode.right == null) {
                flag = true;
            }
            else if (flag) {
                return false;
            }
            else {
                q.offer(currNode.right);
            }
        }
        return true;
    }
}
