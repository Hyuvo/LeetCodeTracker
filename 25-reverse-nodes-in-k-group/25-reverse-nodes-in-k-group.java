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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        //first reverse first k nodes, then regard the left list as a new list to reverse next k nodes
        
        ListNode probe = head; // test if left nodes count < k(probe step out of boundary)
        for(int i = 0; i < k; ++i) {
            if(probe == null) return head;
            probe = probe.next;
        }
        
        ListNode newHead = reverseFirstK(head, k);
        //the successor of head.next should be the reversed lefted part
        head.next = reverseKGroup(successor, k);
        return newHead;
    }
    

    private static ListNode successor = null;
    public ListNode reverseFirstK(ListNode head, int k) {
        if (k == 1) {
            //update successor to be connected
            successor = head.next;
            return head;
        }
        
        ListNode newHead = reverseFirstK(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}

    