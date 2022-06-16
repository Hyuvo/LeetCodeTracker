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
    private int currentDepth = 0;
    private int maxDepth = 0;
    
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }
    
    public void traverse(TreeNode root) {
        if(root == null) return;
        
        currentDepth++;
            
        if (root.left == null && root.left == null) {
            maxDepth = Math.max(maxDepth, currentDepth);
        }
        
        traverse(root.left);
        traverse(root.right);
        
        currentDepth--;
            
            
    }
    
}