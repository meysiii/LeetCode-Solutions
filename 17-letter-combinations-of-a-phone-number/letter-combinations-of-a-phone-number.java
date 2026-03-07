import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, digits, "", 0, map);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index, String[] map) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            backtrack(result, digits, current + c, index + 1, map);
        }
    }
}