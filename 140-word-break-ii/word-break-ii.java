import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        return dfs(s, set, new HashMap<>());
    }

    private List<String> dfs(String s, Set<String> set,
                             Map<String, List<String>> memo) {

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (String word : set) {

            if (s.startsWith(word)) {

                List<String> subList =
                        dfs(s.substring(word.length()), set, memo);

                for (String sub : subList) {

                    if (sub.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(s, result);

        return result;
    }
}