import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(List<String> result, String s, int index, List<String> parts) {
        // If we got 4 parts and used all characters
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try 1 to 3 digits
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            // Check valid
            if (isValid(part)) {
                parts.add(part);
                backtrack(result, s, index + len, parts);
                parts.remove(parts.size() - 1); // backtrack
            }
        }
    }

    private boolean isValid(String part) {
        // No leading zero
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}