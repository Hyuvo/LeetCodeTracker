/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // intersection of 2 linked list
        Node p1 = p, p2 = q;
        while(p1 != p2) {
            if (p1 == null) {
                p1 = q;
            } else {
                p1 = p1.parent;
            }
            if (p2 == null) {
                p2 = p;
            } else {
                p2 = p2.parent;
            }
        }
        return p1;
    }
}