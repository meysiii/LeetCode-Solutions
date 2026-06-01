class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int low = 0;
        int high = Math.min(m, n);

        while (low < high) {
            int mid = (low + high + 1) / 2;

            if (canFind(prefix, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canFind(int[][] prefix, int size, int threshold) {
        for (int i = size; i < prefix.length; i++) {
            for (int j = size; j < prefix[0].length; j++) {

                int sum = prefix[i][j]
                        - prefix[i - size][j]
                        - prefix[i][j - size]
                        + prefix[i - size][j - size];

                if (sum <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }
}