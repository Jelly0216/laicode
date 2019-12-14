public class Solution {
    public String remove(String input, String t) {
        // Write your solution here
        char[] inputArray = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int slow = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            if (!set.contains(inputArray[fast])) {
                inputArray[slow] = inputArray[fast];
                slow++;
            }
        }
        return new String(inputArray, 0, slow);
    }
}
