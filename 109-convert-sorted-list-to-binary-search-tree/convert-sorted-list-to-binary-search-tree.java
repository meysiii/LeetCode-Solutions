class Solution {
    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;

        int size = getSize(head);
        return build(0, size - 1);
    }

    private int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;

        // Build left subtree
        TreeNode leftNode = build(left, mid - 1);

        // Root
        TreeNode root = new TreeNode(head.val);
        root.left = leftNode;

        head = head.next;

        // Build right subtree
        root.right = build(mid + 1, right);

        return root;
    }
}