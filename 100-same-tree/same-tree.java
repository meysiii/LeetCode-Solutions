class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null
        if (p == null && q == null) return true;

        // Case 2: one null
        if (p == null || q == null) return false;

        // Case 3: values different
        if (p.val != q.val) return false;

        // Check left and right
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}