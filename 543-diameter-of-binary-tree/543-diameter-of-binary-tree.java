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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);        
        return maxDiameter;
        
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        depth = Math.max(leftDepth, rightDepth) + 1;
        
        return depth;
    }
}