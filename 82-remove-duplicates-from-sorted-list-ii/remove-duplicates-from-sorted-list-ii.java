class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check if duplicate sequence exists
            if (curr.next != null && curr.val == curr.next.val) {
                int val = curr.val;

                // Skip all nodes with same value
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }

                // Connect prev to next distinct node
                prev.next = curr;
            } else {
                // No duplicate → move prev
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}