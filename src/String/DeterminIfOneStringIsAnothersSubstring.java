package String;

public class DeterminIfOneStringIsAnothersSubstring {
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

        public static void main(String [ ] args)
        {
            String s1 = "abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu";
            String s2 = "qrstuvwxyzzabcdefghijklmnopqrstu";
            DeterminIfOneStringIsAnothersSubstring d1 = new DeterminIfOneStringIsAnothersSubstring();
            int res = d1.strstr(s1,s2);
            System.out.println(res);
        }
    }

