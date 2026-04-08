class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // both null
        if (left == null && right == null) return true;

        // one null
        if (left == null || right == null) return false;

        // values must match
        if (left.val != right.val) return false;

        // check mirror condition
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}