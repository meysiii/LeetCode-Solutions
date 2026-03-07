import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = col
        Arrays.fill(queens, -1);
        backtrack(res, queens, n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    private void backtrack(List<List<String>> res, int[] queens, int n, int row,
                           Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            res.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col; // main diagonal
            int d2 = row + col; // anti-diagonal
            if (columns.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
                continue; // not safe
            }

            queens[row] = col;
            columns.add(col);
            diag1.add(d1);
            diag2.add(d2);

            backtrack(res, queens, n, row + 1, columns, diag1, diag2);

            // backtrack
            queens[row] = -1;
            columns.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}