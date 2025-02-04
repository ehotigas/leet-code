import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> longestSubstring = new HashMap<>();
        Map<Character, Integer> tempLongestSubstring = new HashMap<>();
        Character lastChar = null;

        for (int stringIndex = 0; stringIndex < s.length(); stringIndex++) {
            Character c = s.charAt(stringIndex);
            if (lastChar == null)  {
                lastChar = c;
                tempLongestSubstring.put(c, stringIndex);
                longestSubstring = tempLongestSubstring;
                continue;
            }
            if (tempLongestSubstring.keySet().contains(c)) {
                tempLongestSubstring = new HashMap<>();
                tempLongestSubstring.put(c, stringIndex);
            }
            else {
                tempLongestSubstring.put(c, stringIndex);
            }
            if (longestSubstring.keySet().size() < tempLongestSubstring.keySet().size()) {
                longestSubstring = tempLongestSubstring;
            }
            lastChar = c;
        }
        System.out.println(longestSubstring);
        return longestSubstring.keySet().size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
