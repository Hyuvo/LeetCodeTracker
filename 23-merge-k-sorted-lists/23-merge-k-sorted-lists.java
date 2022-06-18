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
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        // init a priority queue to store the head of each list
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b) -> (a.val - b.val));
        
        for (ListNode head : lists) {
            if(head != null) pq.offer(head);
        }
        
        while(!pq.isEmpty()) {
            //add the minimum node from pq to the result list
            ListNode node = pq.poll();
            p.next = node;
            //add the next node from the original list to pq
            if(node.next != null) {
                pq.offer(node.next);
            }
            
            // pointer p moves forward
            p = p.next;
            
        
            
        }
        
        return dummy.next;
    }
}