package Tree;

public class Solution {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }
        TreeNode curr = root;
        while (curr.key != key) {
            if (curr.key > key) {
                if (curr.left == null) {
                    curr.left = newNode;
                }
                curr = curr.left;
            }
            else if (curr.key < key) {
                if (curr.right == null) {
                    curr.right = newNode;
                }
                curr = curr.right;
            }
        }
        return root;
    }
}