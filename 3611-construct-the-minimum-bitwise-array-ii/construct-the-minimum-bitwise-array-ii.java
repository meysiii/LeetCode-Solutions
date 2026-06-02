class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if (x == 2) {
                ans[i] = -1;
                continue;
            }

            int cnt = 0;
            int temp = x;

            while ((temp & 1) == 1) {
                cnt++;
                temp >>= 1;
            }

            ans[i] = x - (1 << (cnt - 1));
        }

        return ans;
    }
}