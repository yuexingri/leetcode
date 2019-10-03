import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                priorityQueue.add(l);
            }
        }
        ListNode newHead = null;
        ListNode curNod = null;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            if (newHead == null) {
                newHead = curNod = node;
            } else {
                curNod.next = node;
                curNod = curNod.next;
            }
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }
        return newHead;
    }
}
