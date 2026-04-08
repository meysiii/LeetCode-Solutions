class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;

        // Process each query
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int idx = l; idx <= r; idx += k) {
                long updated = ((long) nums[idx] * v) % MOD;
                nums[idx] = (int) updated;
            }
        }

        // Compute XOR
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}