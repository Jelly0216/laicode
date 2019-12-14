package Recursion;

public class Solution {
    public int fibonacci(int K) {
        // Write your solution here
        if(K <= 0) return 0;
        if(K == 1) return 1;
        return fibonacci(K - 1) + fibonacci(K - 2);
    }
}
