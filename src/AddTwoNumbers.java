public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(9);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode listNode = addTwoNumbers(l1_1, l2_1);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (checkIsZero(l1)) {
            return l2;
        }

        if (checkIsZero(l2)) {
            return l1;
        }
        ListNode result = null;
        ListNode topNode = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int tmpSum = l1Val + l2Val + carry;
            carry = tmpSum / 10;
            ListNode currentNode = new ListNode(tmpSum - 10 * carry);
            if (result == null && topNode == null) {
                result = currentNode;
                topNode = currentNode;
            } else {
                result.next = currentNode;
            }
            result = currentNode;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return topNode;
    }

    private static boolean checkIsZero(ListNode listNode) {
        while (listNode != null && listNode.val == 0) {
            listNode = listNode.next;
        }
        return listNode == null;
    }
}
