import java.util.HashMap;
import java.util.Map;

class StringCharMap {
    private Map<Character, Integer> charMap;
    public StringCharMap() {
        charMap = new HashMap<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        StringCharMap other = (StringCharMap) obj;
        if (charMap == null) {
            if (other.charMap != null) return false;
        } else if (!charMap.equals(other.charMap)) return false;
        return true;
    }

    public void put(Character c) {
        if (charMap.keySet().contains(c)) {
            charMap.replace(c, charMap.get(c) + 1);
            return;
        }
        charMap.put(c, 0);
    }
}


public class Problem1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        int differencesCounter = 0;
        StringCharMap s1CharMap = new StringCharMap();
        StringCharMap s2CharMap = new StringCharMap();

        for (int strIdx = 0; strIdx < s1.length(); strIdx++) {
            Character c1 = s1.charAt(strIdx);
            Character c2 = s2.charAt(strIdx);
            s1CharMap.put(c1);
            s2CharMap.put(c2);
            if (!c1.equals(c2)) differencesCounter++;
            if (differencesCounter > 2) return false;
        }
        return s1CharMap.equals(s2CharMap);
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
