import java.util.List;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = head.next = new ListNode(2);
        ListNode thirdNode = secNode.next = new ListNode(3);
        ListNode fourNode = thirdNode.next = new ListNode(4);
        ListNode firNode = fourNode.next = new ListNode(5);
        ListNode listNode = swapPairs(head);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode curHead = new ListNode(0);
        curHead.next = head;
        ListNode p = curHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return curHead.next;
    }
}
