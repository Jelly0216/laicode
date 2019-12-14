package Bit;

public class Solution {
    public long reverseBits(long n) {
        // Write your solution here
        int i = 0;
        int j = 31;
        while (i < j) {
            n = reverse(n, i, j);
            i++;
            j--;
        }
        return n;
    }
    private long reverse(long n, int i, int j) {
        long left = ((n >> j) & 1L);
        long right = ((n >> i) & 1L);
        if (left != right) {
            n ^= ((1L << j) | (1L << i));
        }
        return n;
    }
}
