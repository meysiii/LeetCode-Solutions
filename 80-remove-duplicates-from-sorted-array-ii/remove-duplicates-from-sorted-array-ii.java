class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 2) return n;

        int k = 2; // first 2 elements always valid

        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}