class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);

        ListNode beforeTail = before;
        ListNode afterTail = after;

        while (head != null) {
            if (head.val < x) {
                beforeTail.next = head;
                beforeTail = beforeTail.next;
            } else {
                afterTail.next = head;
                afterTail = afterTail.next;
            }
            head = head.next;
        }

        afterTail.next = null; // avoid cycle
        beforeTail.next = after.next;

        return before.next;
    }
}