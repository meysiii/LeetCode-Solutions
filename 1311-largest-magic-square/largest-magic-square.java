class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
            }
        }

        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i + 1][j + size] - row[i + 1][j];

                    boolean valid = true;

                    for (int r = i; r < i + size; r++) {
                        int sum = row[r + 1][j + size] - row[r + 1][j];

                        if (sum != target) {
                            valid = false;
                            break;
                        }
                    }

                    if (!valid) {
                        continue;
                    }

                    for (int c = j; c < j + size; c++) {
                        int sum = col[i + size][c + 1] - col[i][c + 1];

                        if (sum != target) {
                            valid = false;
                            break;
                        }
                    }

                    if (!valid) {
                        continue;
                    }

                    int diag1 = 0;
                    int diag2 = 0;

                    for (int k = 0; k < size; k++) {
                        diag1 += grid[i + k][j + k];
                        diag2 += grid[i + k][j + size - 1 - k];
                    }

                    if (diag1 == target && diag2 == target) {
                        return size;
                    }
                }
            }
        }

        return 1;
    }
}