class Solution {
    long total = 0;
    long maxProduct = 0;
    int mod = 1000000007;

    public int maxProduct(TreeNode root) {
        total = sum(root);
        dfs(root);
        return (int)(maxProduct % mod);
    }

    private long sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + sum(node.left) + sum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long subTreeSum = node.val + dfs(node.left) + dfs(node.right);

        maxProduct = Math.max(maxProduct, subTreeSum * (total - subTreeSum));

        return subTreeSum;
    }
}