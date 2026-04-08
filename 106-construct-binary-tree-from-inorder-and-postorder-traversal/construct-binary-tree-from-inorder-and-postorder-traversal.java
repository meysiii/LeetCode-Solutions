import java.util.*;

class Solution {
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Build hashmap for inorder index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);

        // IMPORTANT: build right first
        root.right = helper(inorder, postorder, index + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, index - 1);

        return root;
    }
}