class Solution {

    int MOD = 1000000007;
    int[][][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[zero + 1][one + 1][2][limit + 1];

        for (int i = 0; i <= zero; i++)
            for (int j = 0; j <= one; j++)
                for (int k = 0; k < 2; k++)
                    for (int l = 0; l <= limit; l++)
                        dp[i][j][k][l] = -1;

        int startWithZero = dfs(zero - 1, one, 0, 1, limit);
        int startWithOne = dfs(zero, one - 1, 1, 1, limit);

        return (startWithZero + startWithOne) % MOD;
    }

    private int dfs(int zero, int one, int last, int count, int limit) {
        if (zero == 0 && one == 0) return 1;

        if (dp[zero][one][last][count] != -1)
            return dp[zero][one][last][count];

        long ans = 0;

        if (last == 0) {

            if (zero > 0 && count < limit)
                ans += dfs(zero - 1, one, 0, count + 1, limit);

            if (one > 0)
                ans += dfs(zero, one - 1, 1, 1, limit);

        } else {

            if (one > 0 && count < limit)
                ans += dfs(zero, one - 1, 1, count + 1, limit);

            if (zero > 0)
                ans += dfs(zero - 1, one, 0, 1, limit);
        }

        return dp[zero][one][last][count] = (int)(ans % MOD);
    }
}