class Solution:
    def addBinary(self, a: str, b: str) -> str:
        x, y = int(a, 2), int(b, 2) 
        # while still have carry
        while y:
            # sum without carry
            answer = x ^ y
            # track carry
            carry = (x & y) << 1
            # use x to track answer, y to track carry
            x, y = answer, carry
            # remove prefix "0b"
        return bin(x)[2:]
            