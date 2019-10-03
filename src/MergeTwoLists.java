public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val < l2.val) {
                newHead = l1;
                newHead.next = mergeTwoLists(l1.next, l2);
            } else {
                newHead = l2;
                newHead.next = mergeTwoLists(l1, l2.next);
            }
        }
        return newHead;
    }
}
