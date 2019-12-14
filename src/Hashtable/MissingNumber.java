public class Solution {
    public int missing(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 1;
        }
        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }
}
