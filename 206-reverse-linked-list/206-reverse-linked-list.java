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
    public ListNode reverseList(ListNode head) {
        // base case: if the list is empty or contains only 1 node
        if(head == null || head.next == null) {
            return head;
        }
        // the end node of the original list is the head of the reversed list
        ListNode end = reverseList(head.next);
        // consider the definition of the method, what will be returned eventually
        head.next.next = head; //magic
        head.next = null;
        
        return end;
    }
}