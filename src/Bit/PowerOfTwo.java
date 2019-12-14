package Bit;

public class Solution {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        int count = 0;
        int currNumber = number;
        while (currNumber > 0) {
            int one = currNumber & 1;
            count += one;
            currNumber = currNumber >>> 1;
        }
        if (number > 0 && count == 1) {
            return true;
        }
        return false;
    }
}
