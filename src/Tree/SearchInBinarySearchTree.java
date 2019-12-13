package Tree;

public class Solution {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.key > key) {
                root = root.left;
            }
            else if (root.key < key) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
