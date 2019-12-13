package BfsDfs;

public class Solution {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                subList.add(currNode.key);
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            res.add(subList);
        }
        return res;
    }
}