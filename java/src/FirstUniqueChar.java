import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

record MapNode(int idx, boolean hasOne) {
}

class MyMap {
    private Map<Character, MapNode> map;
    public MyMap() {
        map = new HashMap<>();
    }

    public void put(Character key, int value) {
        if (map.keySet().contains(key)) {
            map.replace(key, new MapNode(value, false));
            return;
        }
        map.put(key, new MapNode(value, true));
    }

    public MapNode get(Character key) {
        return map.get(key);
    }

    public Set<Character> keySet() {
        return map.keySet();
    }

    public Collection<MapNode> values() {
        return map.values();
    }
}

public class FirstUniqueChar {
    public int firstUniqueChar(String s) {
        MyMap map = new MyMap();
        for (int strIdx = 0; strIdx < s.length(); strIdx++) {
            map.put(s.charAt(strIdx), strIdx);
        }

        int minIdx = s.length() + 1;
        for (MapNode node : map.values()) {
            if (node.hasOne() && node.idx() < minIdx) minIdx = node.idx();
        }
        return minIdx;
    }
    
    public static void main(String[] args) {
        
    }
}