import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;

        path.add(root.val);

        // leaf node
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
        } else {
            helper(root.left, sum - root.val, path, res);
            helper(root.right, sum - root.val, path, res);
        }

        path.remove(path.size() - 1); // backtrack
    }
}