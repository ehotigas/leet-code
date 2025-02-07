import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (uniqueChars.contains(c)) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }

            uniqueChars.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "";
        System.out.println("Resposta: " + lengthOfLongestSubstring(s));
    }
}
