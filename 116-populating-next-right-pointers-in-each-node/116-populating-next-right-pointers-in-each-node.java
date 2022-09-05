/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        // treat as a ternary tree
        traverse(root.left, root.right);
        return root;
    }
    
    public void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        
        // pre-order position, connect
        node1.next = node2;
        
        // ternary tree traversal
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // connect nodes belonging to diff sub root
        traverse(node1.right, node2.left);
    }
}