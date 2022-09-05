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
    public void flatten(TreeNode root) {
        // need to flatten in place
        if (root == null) return;
        
        // 1. flatten left and right sub-tree respectively
        flatten(root.left);
        flatten(root.right);
        
        // 2. make left sub to right
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        root.right = left;
        
        // 3. connect old right subtree to the end of new right subtree
        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }
        p.right = right;
        
        
    }
}