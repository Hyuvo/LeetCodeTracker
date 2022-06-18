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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a dummy head to prevent from the situation of deleting the 1st node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // need to get the n+1 th node from the end, and connect n-1th to it
        // need to use dummy head instead of the true head
        ListNode m = findNthFromEnd(dummy, n+1);
        m.next = m.next.next;
        
        return dummy.next;
    }
    
    public ListNode findNthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // let p1 move k steps forward
        for(int i = 0; i < k; ++i) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null) {
            // use p1 to count n-k steps to reach the kth node from the end
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}