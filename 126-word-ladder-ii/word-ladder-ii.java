import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!wordSet.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        level.put(beginWord, 0);

        int len = beginWord.length();

        while (!queue.isEmpty()) {

            String word = queue.poll();
            int steps = level.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < len; i++) {

                char original = arr[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    arr[i] = c;
                    String next = new String(arr);

                    if (wordSet.contains(next)) {

                        if (!level.containsKey(next)) {
                            level.put(next, steps + 1);
                            queue.offer(next);
                            map.put(next, new ArrayList<>());
                            map.get(next).add(word);
                        } 
                        else if (level.get(next) == steps + 1) {
                            map.get(next).add(word);
                        }
                    }
                }

                arr[i] = original;
            }
        }

        if (!level.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, map, path, result);

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> map,
                           List<String> path,
                           List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!map.containsKey(word)) {
            return;
        }

        for (String prev : map.get(word)) {

            path.add(prev);
            backtrack(prev, beginWord, map, path, result);
            path.remove(path.size() - 1);
        }
    }
}