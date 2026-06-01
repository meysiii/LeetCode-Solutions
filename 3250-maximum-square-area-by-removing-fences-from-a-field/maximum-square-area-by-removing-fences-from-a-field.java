class Solution {
    long mod = 1000000007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);

        v.add(1);
        v.add(n);

        for (int x : hFences) {
            h.add(x);
        }

        for (int x : vFences) {
            v.add(x);
        }

        Collections.sort(h);
        Collections.sort(v);

        HashSet<Integer> hDiff = new HashSet<>();

        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hDiff.add(h.get(j) - h.get(i));
            }
        }

        long maxSide = 0;

        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                int diff = v.get(j) - v.get(i);

                if (hDiff.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }

        if (maxSide == 0) {
            return -1;
        }

        return (int)((maxSide * maxSide) % mod);
    }
}