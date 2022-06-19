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
    private static ListNode successor = null;
    // left = 1
    public ListNode reverseFirstN(ListNode head, int n) {        
        // base case: reverse the first 1 node
        if(n == 1) {
            successor = head.next;
            return head;
        }
        //by definition, reverse first n nodes equals to reverse first n-1 nodes if start at head.next
        ListNode end = reverseFirstN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        
        return end;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base case: left is 1 => reverse first n nodes
        if(left == 1) {
            return reverseFirstN(head, right);
        }
        //if left != 1, move forward to left-1 to start reverse
        //reverse from head equals to reverse from head.next with first left -1 nodes
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }
    

}