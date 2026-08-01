class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }

        int l = 0, r = n - 1;

        while (l < n && s.charAt(l) == '1') l++;
        while (r >= 0 && s.charAt(r) == '1') r--;

        if (l > r) return ones;

        List<int[]> store = new ArrayList<>();

        int len = 1;
        for (int i = l + 1; i <= r; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                store.add(new int[]{len, s.charAt(i - 1)});
                len = 1;
            }
        }
        store.add(new int[]{len, s.charAt(r)});

        int maxRange = 0;
        for (int i = 0; i + 2 < store.size(); i += 2) {
            int gain = store.get(i)[0] + store.get(i + 2)[0];
            maxRange = Math.max(maxRange, gain);
        }

        return ones + maxRange;
    }
}