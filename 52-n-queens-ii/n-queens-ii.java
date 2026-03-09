class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        solve(0, n, col, diag1, diag2);
        return count;
    }

    private void solve(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag1[row - c + n] || diag2[row + c])
                continue;

            col[c] = true;
            diag1[row - c + n] = true;
            diag2[row + c] = true;

            solve(row + 1, n, col, diag1, diag2);

            col[c] = false;
            diag1[row - c + n] = false;
            diag2[row + c] = false;
        }
    }
}