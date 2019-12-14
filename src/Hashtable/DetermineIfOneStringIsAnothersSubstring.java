public class Solution {
    public int strstr(String large, String small) {
        // Write your solution here
        if (large == null || small == null || large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            int j = 0;
            while (j < small.length() && small.charAt(j) == large.charAt(i+j)) {
                j++;
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }
}
