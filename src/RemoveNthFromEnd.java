public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = head.next = new ListNode(2);
//        ListNode thirdNode = secNode.next = new ListNode(3);
//        ListNode fourNode = thirdNode.next = new ListNode(4);
//        ListNode firNode = fourNode.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        if (q == null) {
            return head.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
