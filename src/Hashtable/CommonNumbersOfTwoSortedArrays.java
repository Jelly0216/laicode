public class Solution {
    public List<Integer> common(int[] A, int[] B) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while ( i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                res.add(A[i]);
                i++;
                j++;
            }
            else if (A[i] < B[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return res;
    }
}
