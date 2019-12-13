package Tree;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        getRange(root, min, max, res);
        return res;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            getRange(root.left, min, max, res);
        }
        if (root.key >= min && root.key <= max) {
            res.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, res);
        }
    }
}