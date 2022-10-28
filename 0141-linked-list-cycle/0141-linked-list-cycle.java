/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 2-pointer
        // ListNode dummy = head;
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            // 1 step each iteration
            slow = slow.next;
            // 2 step
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}