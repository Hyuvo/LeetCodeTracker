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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;
        ListNode p1 = list1, p2 = list2;
        
        while(p1 != null && p2 != null) {
            
            // connect the node with small value to result list
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        // connect the left non-empty list to the result list
        p.next = (p1 != null) ? p1 : p2;
        
        return dummyHead.next;
    }
}