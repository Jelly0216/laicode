public class Solution {
    public boolean allUnique(String word) {
        // Write your solution here
        int[] baseVector = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i);
            int row = a / 32;
            int col = a % 32;
            if ((baseVector[row] >> col & 1)  != 0){
                return false;
            }
            baseVector[row] |= 1 << col;
        }
        return true;
    }
}
