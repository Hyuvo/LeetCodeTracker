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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Init a dummy head for the result linked list
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode p = l1, q = l2, currentDigit = dummyHead;
                
        while(p != null || q != null){            
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;            
            currentDigit.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            // Move to the next digit
            currentDigit = currentDigit.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }  
        
        // If the last digit has a carry
        if (carry > 0) currentDigit.next = new ListNode(1);
                
        return dummyHead.next;
    }
}

