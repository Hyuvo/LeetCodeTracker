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
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        
        // pre-order position
        // swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // go to children
        traverse(root.left);
        traverse(root.right);
    }
}