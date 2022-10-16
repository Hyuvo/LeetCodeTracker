/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        // use priority queue to get the head with the current min val
        // Queue<ListNode> pq = new PriorityQueue<>((a, b) -> {
        //     return a.val - b.val;
        // });
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // init qp with heads
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        // adding node ascendingly
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummyHead.next;
    }
}