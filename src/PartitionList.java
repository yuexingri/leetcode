public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNodeLt = new ListNode(-1);
        ListNode dummyNodeGt = new ListNode(-1);
        ListNode ltNodes = dummyNodeLt;
        ListNode gtNodes = dummyNodeGt;
        for (ListNode cur = head; cur != null; ) {
            if (cur.val < x) {
                ltNodes.next = cur;
                cur = cur.next;
                ltNodes = ltNodes.next;
                ltNodes.next = null;
            } else {
                gtNodes.next = cur;
                cur = cur.next;
                gtNodes = gtNodes.next;
                gtNodes.next = null;
            }
        }

        ltNodes.next = dummyNodeGt.next;
        return dummyNodeLt.next;
    }
}
