package String;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public String replace(String input, String source, String target) {
        char[] array = input.toCharArray();
        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }

    private String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (fast <= input.length - s.length() && equalsString(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            }
            else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t) {
        List<Integer> matches = getAllMatches(input, s);
        char[] res = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = res.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(res, slow - t.length() + 1, t);
                fast -= s.length();
                slow -= t.length();
                lastIndex--;
            }
            else {
                res[slow--] = input[fast--];
            }
        }
        return new String(res);
    }

    private List<Integer> getAllMatches(char[] input, String s) {
        List<Integer> matches = new ArrayList<Integer>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalsString(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            }
            else {
                i++;
            }
        }
        return matches;
    }

    private boolean equalsString(char[] input, int start, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[start + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void copySubstring(char[] array, int start, String t) {
        for (int i = 0; i < t.length(); i++) {
            array[start + i] = t.charAt(i);
        }
    }

}
