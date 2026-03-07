import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array, sort it, then back to string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add original string to the corresponding list in the map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}