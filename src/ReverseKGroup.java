public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode lastGruop = pointer;
            int i = 0;
            for (; i < k; ++i) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }

            if (i == k) {
                ListNode nextGroup = pointer.next;
                ListNode reversedList = reverse(lastGruop.next, nextGroup);
                pointer = lastGruop.next;
                lastGruop.next = reversedList;
                pointer.next = nextGroup;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode tmp = null;
        while ((head != null) && (head != tail)) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
