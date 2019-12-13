package Tree;

public class Solution {
    public TreeNode deleteTree(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteTree(root.left, key);
            return root;
        }
        else if (key > root.key) {
            root.right = deleteTree(root.right, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }

        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        TreeNode smallest = deleteSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode curr) {
        TreeNode prev = curr;
        curr = curr.left;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        prev.left = prev.left.right;
        return curr;
    }
}
