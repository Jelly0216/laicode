package BfsDfs;

public class Solution {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(target, coins, 0, curr, res);
        return res;
    }

    private void helper(int target, int[] coins, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                curr.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            curr.add(i);
            helper(target - i * coins[index], coins, index + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
