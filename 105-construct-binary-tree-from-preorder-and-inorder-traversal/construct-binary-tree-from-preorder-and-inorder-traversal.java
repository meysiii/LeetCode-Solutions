import java.util.*;

class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Store inorder index for fast lookup
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Pick current root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root in inorder
        int index = map.get(rootVal);

        // Build left and right
        root.left = helper(preorder, inStart, index - 1);
        root.right = helper(preorder, index + 1, inEnd);

        return root;
    }
}