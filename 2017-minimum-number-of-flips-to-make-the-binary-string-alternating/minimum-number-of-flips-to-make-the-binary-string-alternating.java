class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int diff1 = 0, diff2 = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < t.length(); right++) {

            char expected1 = (right % 2 == 0) ? '0' : '1'; // pattern 0101
            char expected2 = (right % 2 == 0) ? '1' : '0'; // pattern 1010

            if (t.charAt(right) != expected1) diff1++;
            if (t.charAt(right) != expected2) diff2++;

            if (right - left + 1 > n) {
                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (t.charAt(left) != leftExpected1) diff1--;
                if (t.charAt(left) != leftExpected2) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                result = Math.min(result, Math.min(diff1, diff2));
            }
        }

        return result;
    }
}