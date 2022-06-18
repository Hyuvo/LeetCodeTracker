# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = head
        slow = head
        
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next
            
            #when fast catches slow, the distance from meet point to the cycle begin point 
            #equals to the distance from the head of the list to the start point of the cycle
            if fast is slow:
                break
        
        #If the fast pointer can reach the null pointer at the end, there's no cycle
        if fast is None or fast.next is None:
            return None

        #reset a pointer to the head, then set them with the same pace, 
        #they will meet at the start point of the cycle
        fast = head
        
        while fast is not slow:
            fast = fast.next
            slow = slow.next
            
        return fast