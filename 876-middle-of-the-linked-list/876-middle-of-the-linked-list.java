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
    public ListNode middleNode(ListNode head) {
        // use a slow pointer and a fast pointer, the fast pointer move 2 steps forward, when the slow pointer moves 1 step
        // then when the fast pointer reaches the null pointer at the end
        // the slow pointer will just reach the middle node;
        
        ListNode slow = head, fast = head;
        // the next 2 steps of fast point cannot be null
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}