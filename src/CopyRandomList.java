public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node();
            node.val = cur.val;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            cur = cur.next;
        }
        return res;
    }
}
