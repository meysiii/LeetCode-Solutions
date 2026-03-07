class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // check if there are at least k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {

            // reverse first k nodes
            ListNode prev = reverseKGroup(curr, k);

            while (count > 0) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
                count--;
            }

            head = prev;
        }

        return head;
    }
}