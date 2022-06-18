# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1 = headA
        p2 = headB
        
        while p1 != p2:
            # if either pointer reaches the end of a list, switch it to the head of the other list
            # connect 2 lists togeter, then the 2 pointers will meet at the intersection node
            
            p1 = headB if p1 is None else p1.next               
            p2 = headA if p2 is None else p2.next    
        
        return p1