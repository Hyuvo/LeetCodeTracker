/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // if the node has no child or only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // if the node has 2 children
            // find the max in left subtree or the min in the right subtree
            // swap and delete
            TreeNode successor = getSuccessor(root.right);
            root.right = deleteNode(root.right, successor.val);
            
            successor.left = root.left;
            successor.right = root.right;
            root = successor;            
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    
    public TreeNode getSuccessor(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}